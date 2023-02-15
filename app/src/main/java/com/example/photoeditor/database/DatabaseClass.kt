package com.example.photoeditor.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [SpecieModel::class], version = 1)
abstract class DatabaseClass : RoomDatabase() {
    abstract fun userDao(): SpeciesDao
}
