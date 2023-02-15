package com.example.photoeditor.database

import androidx.room.Dao
import androidx.room.Query


@Dao
interface SpeciesDao {
    @Query("Select * from SpecieModel")
    fun getAllUsersDetails(): List<SpecieModel>
}