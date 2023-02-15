package com.example.photoeditor.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class RetrofitError(
    var error: String,
    var code: Int,
    var isInternet: Boolean
) : Parcelable {

    override fun toString(): String {
        return "RetrofitError(error='$error', code=$code, isInternet=$isInternet)"
    }
}
