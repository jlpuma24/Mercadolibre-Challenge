package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName



data class Installments (

  @SerializedName("quantity"    ) var quantity   : Double?    = null,
  @SerializedName("amount"      ) var amount     : Double?    = null,
  @SerializedName("rate"        ) var rate       : Double?    = null,
  @SerializedName("currency_id" ) var currencyId : String? = null

)