package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName



data class Sales (

  @SerializedName("period"    ) var period    : String? = null,
  @SerializedName("completed" ) var completed : Int?    = null

)