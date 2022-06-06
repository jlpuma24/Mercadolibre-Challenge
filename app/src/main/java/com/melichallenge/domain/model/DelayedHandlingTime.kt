package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName



data class DelayedHandlingTime (

  @SerializedName("period" ) var period : String? = null,
  @SerializedName("rate"   ) var rate   : Double? = null,
  @SerializedName("value"  ) var value  : Int?    = null

)