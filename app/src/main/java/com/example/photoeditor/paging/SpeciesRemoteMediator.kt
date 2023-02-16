package com.example.photoeditor.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.photoeditor.database.AppDatabase
import com.example.photoeditor.database.IRepository
import com.example.photoeditor.models.SpecieModel
import com.example.photoeditor.network.NetworkResult
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class SpeciesRemoteMediator(private val iRepository: IRepository, private val appDatabase: AppDatabase) : RemoteMediator<Int, SpecieModel>() {

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - (5000) < cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, SpecieModel>): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    }
                    lastItem.id
                }
            }
            val response = iRepository.getAllSpeciesFromRemote()
            val species = ArrayList<SpecieModel>()
            when (response) {
                is NetworkResult.Success -> species.addAll(response.data)
                else -> {}
            }
            appDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    appDatabase.speciesDao().clearAllSpecies()
                }
                appDatabase.speciesDao().insertAll(species)
            }

            MediatorResult.Success(endOfPaginationReached = species.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}