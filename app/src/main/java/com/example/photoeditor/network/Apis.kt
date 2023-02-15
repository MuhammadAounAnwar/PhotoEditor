package com.example.photoeditor.network

import com.example.photoeditor.database.SpecieModel
import retrofit2.Response
import retrofit2.http.GET

interface Apis {
    @GET
    suspend fun getAllSpecies(): Response<SpecieModel>
}