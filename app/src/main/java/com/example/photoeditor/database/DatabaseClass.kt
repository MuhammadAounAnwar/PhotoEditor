package com.example.photoeditor.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photoeditor.models.SpecieModel


@Database(entities = [SpecieModel::class], version = 1)
abstract class DatabaseClass : RoomDatabase() {
    abstract fun speciesDao(): SpeciesDao
}
