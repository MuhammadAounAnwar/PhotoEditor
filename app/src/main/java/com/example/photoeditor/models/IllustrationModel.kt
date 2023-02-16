package com.example.photoeditor.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class IllustrationModel(
    @ColumnInfo(name = "src") @Expose @SerializedName("src") var src: String? = "",
    @ColumnInfo(name = "alt") @Expose @SerializedName("alt") var alt: String? = "",
    @ColumnInfo(name = "title") @Expose @SerializedName("title") var title: String? = "",
) : Parcelable
