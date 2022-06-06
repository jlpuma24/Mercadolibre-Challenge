package com.melichallenge.domain.model

import com.google.gson.annotations.SerializedName


data class FilterValue (
    val id: String,
    val name: String,
    @SerializedName("path_from_root")
    val pathFromRoot: List<PathFromRoot>
)