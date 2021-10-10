package com.example.kuispsi

import com.google.gson.annotations.SerializedName

data class CatModel (
    @SerializedName("file")
    val text: String?
)