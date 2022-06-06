package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName



data class Values (

  @SerializedName("id"      ) var id      : String? = null,
  @SerializedName("name"    ) var name    : String? = null,
  @SerializedName("results" ) var results : Int?    = null

)