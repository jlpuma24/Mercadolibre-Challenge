package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName


data class PaymentConditions (
    @SerializedName("allowed_methods")
    val allowedMethods: List<AllowedMethod>,

    @SerializedName("start_time")
    val startTime: String,

    @SerializedName("end_time")
    val endTime: String,

    @SerializedName("restricted_to_prices")
    val restrictedToPrices: List<Any?>
)