package com.example.vkeducationdemo.data.network

import kotlinx.serialization.Serializable

@Serializable
data class CatalogAppDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String,
)

@Serializable
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: String,
    val ageRating: Int,
    val size: Double,
    val iconUrl: String,
    val screenshotUrlList: List<String>? = null,
    val description: String,
)
