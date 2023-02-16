package com.example.photoeditor.database

import com.example.photoeditor.models.SpecieModel
import com.example.photoeditor.network.Apis
import com.example.photoeditor.network.BaseApiResponse
import com.example.photoeditor.network.NetworkResult
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

interface IRepository {
    fun getAllSpecies(): List<SpecieModel>
    suspend fun insertAllSpecies(species: List<SpecieModel>)
    suspend fun getAllSpeciesFromRemote(): NetworkResult<List<SpecieModel>>
}

class RepositoryImpl @Inject constructor(private val apis: Apis, private val speciesDao: SpeciesDao) : IRepository, BaseApiResponse() {
    override fun getAllSpecies(): List<SpecieModel> {
        return speciesDao.getAllSpecies()
    }

    override suspend fun insertAllSpecies(species: List<SpecieModel>) = speciesDao.insertAll(species)

    override suspend fun getAllSpeciesFromRemote(): NetworkResult<List<SpecieModel>> = safeApiCall { apis.getAllSpecies() }
}


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun provideRepo(repositoryImpl: RepositoryImpl): IRepository
}
