package com.example.photoeditor.network

import com.example.photoeditor.models.SpecieModel
import retrofit2.Response
import retrofit2.http.GET

interface Apis {
    @GET("species")
    suspend fun getAllSpecies(): Response<List<SpecieModel>>
}