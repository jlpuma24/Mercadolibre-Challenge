package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class ProductDescription (
    val text: String,
    @SerializedName("plain_text") val plainText: String
)