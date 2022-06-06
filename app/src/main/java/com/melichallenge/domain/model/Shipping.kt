package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Shipping (
  @SerializedName("free_shipping" ) var freeShipping : Boolean?          = null,
  @SerializedName("mode"          ) var mode         : String?           = null,
  @SerializedName("tags"          ) var tags         : ArrayList<String> = arrayListOf(),
  @SerializedName("store_pick_up" ) var storePickUp  : Boolean?          = null,
  @SerializedName("methods"       ) var methods      : ArrayList<String> = arrayListOf(),
  @SerializedName("dimensions"    ) var dimensions   : String?           = null,
  @SerializedName("local_pick_up" ) var localPickUp  : Boolean?          = null,
  @SerializedName("logistic_type" ) var logisticType : String?           = null,
)