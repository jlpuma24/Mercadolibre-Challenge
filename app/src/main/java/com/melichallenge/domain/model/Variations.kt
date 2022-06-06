package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName


data class Variations (

    @SerializedName("id"                     ) var id                    : Double?                             = null,
    @SerializedName("price"                  ) var price                 : Double?                             = null,
    @SerializedName("attribute_combinations" ) var attributeCombinations : ArrayList<AttributeCombinations> = arrayListOf(),
    @SerializedName("available_quantity"     ) var availableQuantity     : Int?                             = null,
    @SerializedName("sold_quantity"          ) var soldQuantity          : Int?                             = null,
    @SerializedName("sale_terms"             ) var saleTerms             : ArrayList<String>                = arrayListOf(),
    @SerializedName("picture_ids"            ) var pictureIds            : ArrayList<String>                = arrayListOf(),
    @SerializedName("catalog_product_id"     ) var catalogProductId      : String?                          = null

)