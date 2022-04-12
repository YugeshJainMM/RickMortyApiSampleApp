package com.example.rickmortypaginationmm.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//object RickMortyClient {
//    private const val BASE_URL = "https://rickandmortyapi.com/api/"
//    private fun getLoggingInterceptor() = HttpLoggingInterceptor()
//        .setLevel(HttpLoggingInterceptor.Level.BASIC)
//
//    private fun getOkHttpClient() = OkHttpClient.Builder()
//        .addInterceptor(getLoggingInterceptor())
//        .build()
//
//    private fun getClient(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(getOkHttpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    val rickMortyService: RickMortyService = getClient().create(RickMortyService::class.java)
//}

object RickMortyClient {
    val INSTANCE: RickMortyService by lazy{
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()
            )
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickMortyService::class.java)
    }
}