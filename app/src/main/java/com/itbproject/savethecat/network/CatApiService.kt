package com.itbproject.savethecat.network

import com.itbproject.savethecat.model.BreedModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers

private const val API_KEY =
    "live_qDdMwDyN6QfFWsBOseWxyXGEBgWVZqoK3t9YGTO8Sn0SpvjStG32ZE9ZRQwdT2Dj"

private const val BASE_URL =
    "https://api.thecatapi.com/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

interface CatApiService {
    @Headers("x-api-key: $API_KEY")
    @GET("breeds")
    suspend fun getBreeds(): List<BreedModel>
}

object CatApi {
    val retrofitService : CatApiService by lazy {
        retrofit.create(CatApiService::class.java)
    }
}