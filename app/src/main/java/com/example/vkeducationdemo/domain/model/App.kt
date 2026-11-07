package com.example.vkeducationdemo.domain.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class App(
    val id: String,
    val name: String,
    val shortDescription: String,
    val category: Category,
    val icon: ImageVector,
    val iconContainer: Color,
    val iconUrl: String? = null,
)
