package com.example.kuispsi

import retrofit2.Call
import retrofit2.http.GET

interface CatApi {
    @GET("meow")
    fun getPicts(): Call<CatModel>
}