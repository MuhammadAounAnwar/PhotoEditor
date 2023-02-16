package com.example.photoeditor.ui.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.photoeditor.database.*
import com.example.photoeditor.paging.SpeciesRemoteMediator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(val application: Application, val appDatabase: AppDatabase, val repo: IRepository) : ViewModel() {

   @Inject
   lateinit var speciesDao: SpeciesDao

   @OptIn(ExperimentalPagingApi::class)
   val data = Pager(
      config = PagingConfig(
         pageSize = 50,
         enablePlaceholders = false,
         initialLoadSize = 50
      ),
      remoteMediator = SpeciesRemoteMediator(
         iRepository = repo,
         appDatabase = appDatabase,
      ),
      pagingSourceFactory = {
         speciesDao.getSpecies()
      }
   ).flow.cachedIn(viewModelScope)

}