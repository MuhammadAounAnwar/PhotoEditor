package com.example.photoeditor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class SpecieModel(
    @PrimaryKey(autoGenerate = true) @Expose @SerializedName("id") var id: Int = 0,
    @ColumnInfo(name = "name") @Expose @SerializedName("name") var name: String? = "",
    @ColumnInfo(name = "description") @Expose @SerializedName("description") var description: Int? = 0
)
