package com.example.photoeditor.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.photoeditor.database.SpeciesDao
import com.example.photoeditor.models.SpecieModel
import kotlinx.coroutines.delay

class MainPagingSource(private val dao: SpeciesDao) : PagingSource<Int, SpecieModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SpecieModel> {
        val page = params.key ?: 0

        return try {
            Log.d("MainPagingSource", "load: $page")
            val entities = dao.getPagedList(params.loadSize, page * params.loadSize)
            if (page != 0) delay(1000)
            LoadResult.Page(
                data = entities,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SpecieModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}