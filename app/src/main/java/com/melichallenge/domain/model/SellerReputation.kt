package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName
import com.melichallenge.domain.model.Metrics



data class SellerReputation (

  @SerializedName("power_seller_status" ) var powerSellerStatus : String?       = null,
  @SerializedName("level_id"            ) var levelId           : String?       = null,
  @SerializedName("metrics"             ) var metrics           : Metrics?      = Metrics(),
  @SerializedName("transactions"        ) var transactions      : Transactions? = Transactions()

)