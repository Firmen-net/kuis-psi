package com.example.kuispsi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatClient {
    private const val BASE_URL = "https://aws.random.cat/"

    val instance: CatApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CatApi::class.java)
    }
}