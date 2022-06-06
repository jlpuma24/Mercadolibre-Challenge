package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class ReviewsResponse (
    @SerializedName("rating average") val ratingAverage: Double,
    val reviews: ArrayList<Review>,
    @SerializedName("rating_levels") val ratingLevels: RatingLevels
)