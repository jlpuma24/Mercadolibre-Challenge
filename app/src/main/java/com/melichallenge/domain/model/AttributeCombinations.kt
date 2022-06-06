package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class AttributeCombinations (

    @SerializedName("id"           ) var id          : String?           = null,
    @SerializedName("name"         ) var name        : String?           = null,
    @SerializedName("value_id"     ) var valueId     : String?           = null,
    @SerializedName("value_name"   ) var valueName   : String?           = null,
    @SerializedName("value_struct" ) var valueStruct : String?           = null,
    @SerializedName("values"       ) var values      : ArrayList<Values> = arrayListOf(),
    @SerializedName("value_type"   ) var valueType   : String?           = null
)