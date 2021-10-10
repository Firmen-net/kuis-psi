package com.example.kuispsi

import retrofit2.Call
import retrofit2.http.GET

interface DogApi {
    @GET("woof.json")
    fun getPicts(): Call<DogModel>
}