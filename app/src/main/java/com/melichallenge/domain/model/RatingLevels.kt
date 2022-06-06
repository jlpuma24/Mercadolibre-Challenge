package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

class RatingLevels (
    @SerializedName("one_star") val oneStar : Int,
    @SerializedName("two_star") val twoStar: Int,
    @SerializedName("three_star") val threeStar : Int,
    @SerializedName("four_star") val fourStar: Int,
    @SerializedName("five_star") val fiveStar: Int
)