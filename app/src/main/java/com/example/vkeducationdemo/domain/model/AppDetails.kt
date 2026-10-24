package com.example.vkeducationdemo.domain.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class AppDetails(
    val id: Long,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val icon: ImageVector,
    val iconContainer: Color,
    val screenshotCount: Int,
    val description: String,
)
