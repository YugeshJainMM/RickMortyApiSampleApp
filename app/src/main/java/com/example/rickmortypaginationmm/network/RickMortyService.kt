package com.example.rickmortypaginationmm.network

import com.example.rickmortypaginationmm.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyService {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): RickAndMortyResponse
}