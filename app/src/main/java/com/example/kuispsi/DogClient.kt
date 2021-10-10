package com.example.kuispsi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogClient {
    private const val BASE_URL = "https://random.dog/"

    val instance: DogApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(DogApi::class.java)
    }
}