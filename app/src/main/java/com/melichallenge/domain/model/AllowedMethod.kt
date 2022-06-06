package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName


data class AllowedMethod (
    val id: String,

    @SerializedName("issuer_id")
    val issuerID: Long,

    @SerializedName("payment_type_id")
    val paymentTypeID: String,

    val installments: Any? = null
)