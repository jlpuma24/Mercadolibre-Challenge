package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName


data class EshopRubro(
    @SerializedName("category_id") val categoryId: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: String
)