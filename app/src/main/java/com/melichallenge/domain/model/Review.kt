package com.melichallenge.domain.model

import java.io.Serializable

data class Review (
    val id: Long,
    val rate: Double,
    val likes: Long,
    val dislikes: Long,
    val content: String,
    val title: String,
): Serializable