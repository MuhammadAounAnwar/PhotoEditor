package com.example.photoeditor.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "species")
data class SpecieModel(
    @PrimaryKey(autoGenerate = true) @Expose @SerializedName("id") var id: Int = 0,
    @ColumnInfo(name = "Species Name") @Expose @SerializedName("Species Name") var species_name: String? = "",
    @ColumnInfo(name = "Texture") @Expose @SerializedName("Texture") var texture: String? = "",
    @Embedded @Expose @SerializedName("Species Illustration Photo") var species_illustration_photo: IllustrationModel? = IllustrationModel()
)
