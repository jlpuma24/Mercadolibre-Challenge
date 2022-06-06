package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName



data class AvailableFilters (

  @SerializedName("id"     ) var id     : String?           = null,
  @SerializedName("name"   ) var name   : String?           = null,
  @SerializedName("type"   ) var type   : String?           = null,
  @SerializedName("values" ) var values : ArrayList<Values> = arrayListOf()

)