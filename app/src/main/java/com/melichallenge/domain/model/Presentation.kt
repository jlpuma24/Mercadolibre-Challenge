package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName



data class Presentation (

  @SerializedName("display_currency" ) var displayCurrency : String? = null

)