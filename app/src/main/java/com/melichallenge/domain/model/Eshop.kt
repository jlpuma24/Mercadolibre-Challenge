package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName



data class Eshop (

  @SerializedName("seller"           ) var seller          : Int?              = null,
  @SerializedName("eshop_rubro"      ) var eshopRubro      : EshopRubro?           = null,
  @SerializedName("eshop_id"         ) var eshopId         : Int?              = null,
  @SerializedName("nick_name"        ) var nickName        : String?           = null,
  @SerializedName("site_id"          ) var siteId          : String?           = null,
  @SerializedName("eshop_logo_url"   ) var eshopLogoUrl    : String?           = null,
  @SerializedName("eshop_status_id"  ) var eshopStatusId   : Int?              = null,
  @SerializedName("eshop_experience" ) var eshopExperience : Int?              = null,
  @SerializedName("eshop_locations"  ) var eshopLocations  : ArrayList<EshopLocation> = arrayListOf()

)