package com.example.photoeditor.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.photoeditor.models.SpecieModel


@Dao
interface SpeciesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<SpecieModel>)

    @Query("Select * From species")
    fun getSpecies(): PagingSource<Int, SpecieModel>

    @Query("Select * from species")
    fun getAllSpecies(): List<SpecieModel>

    @Query("Delete From species")
    suspend fun clearAllSpecies()

    @Query("SELECT * FROM species ORDER BY id ASC LIMIT :limit OFFSET :offset")
    suspend fun getPagedList(limit: Int, offset: Int): List<SpecieModel>
}