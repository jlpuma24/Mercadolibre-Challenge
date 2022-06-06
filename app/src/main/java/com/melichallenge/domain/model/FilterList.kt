package com.melichallenge.domain.model



data class FilterList (
    val id: String,
    val name: String,
    val type: String,
    val values: List<FilterValue>
)