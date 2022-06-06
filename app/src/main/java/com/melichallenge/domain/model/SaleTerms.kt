package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class SaleTerms (
    val id: String,
    val name: String,
    @SerializedName("value_id") val valueId: String,
    @SerializedName("value_name") val valueName : String,
    val values: ArrayList<Values>
)