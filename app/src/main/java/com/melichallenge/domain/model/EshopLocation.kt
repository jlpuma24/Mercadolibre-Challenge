package com.melichallenge.domain.model



data class EshopLocation(
    val country: Country,
    val city: City,
    val neighborhood: Neighborhood,
    val state: State
)