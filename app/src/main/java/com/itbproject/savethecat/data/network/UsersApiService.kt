package com.itbproject.savethecat.data.network

import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.data.models.ImageDto
import com.itbproject.savethecat.data.models.UserDto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL =
    "https://jsonplaceholder.typicode.com/"

val FAKE_PASSWORDS = listOf(
    "Bret123", "Anto234", "Saman345", "Kari456", "Kamr567", "Leop678", "Elwy890", "Maxi901", "Delp012", "Mori123"
)

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

interface UsersApiService {
    @GET("users")
    suspend fun getUsers() : List<UserDto>
}

object UsersApi{
    val retrofitService : UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java)
    }
}