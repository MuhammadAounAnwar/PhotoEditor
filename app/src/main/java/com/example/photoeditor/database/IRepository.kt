package com.example.photoeditor.database

import com.example.photoeditor.network.Apis
import com.example.photoeditor.network.BaseApiResponse
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

interface IRepository {
    fun getAllSpecies(): List<SpecieModel>
}

class RepositoryImpl @Inject constructor(private val apis: Apis, private val speciesDao: SpeciesDao) : IRepository, BaseApiResponse() {
    override fun getAllSpecies(): List<SpecieModel> {
        val species = speciesDao.getAllUsersDetails()
        return emptyList()
    }

    private suspend fun getSpecies(): List<SpecieModel> {
        val res = safeApiCall { apis.getAllSpecies() }
        return emptyList()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun provideRepo(repositoryImpl: RepositoryImpl): IRepository
}
