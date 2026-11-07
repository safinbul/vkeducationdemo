package com.example.vkeducationdemo.data.network

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.domain.model.AppDetails
import com.example.vkeducationdemo.domain.model.Category

private val categoryAliases: Map<String, Category> = mapOf(
    "Бизнес" to Category.BUSINESS,
    "Еда и напитки" to Category.FOOD,
    "Здоровье и фитнес" to Category.HEALTH,
    "Игры" to Category.GAME,
    "Книги и справочники" to Category.BOOKS,
    "Музыка" to Category.MUSIC,
    "Навигация" to Category.MAPS,
    "Новости" to Category.NEWS,
    "Образ жизни" to Category.ENTERTAINMENT,
    "Образование" to Category.EDUCATION,
    "Общение" to Category.SOCIAL,
    "Погода" to Category.UTILITIES,
    "Производительность" to Category.PRODUCTIVITY,
    "Развлечения" to Category.ENTERTAINMENT,
    "Утилиты" to Category.UTILITIES,
    "Финансы" to Category.FINANCE,
    "Фото и видео" to Category.PHOTOGRAPHY,
    "Шопинг" to Category.SHOPPING,
)

private val categoryIcons: Map<Category, ImageVector> = mapOf(
    Category.APP to Icons.Filled.Apps,
    Category.GAME to Icons.Filled.SportsEsports,
    Category.PRODUCTIVITY to Icons.Filled.Note,
    Category.SOCIAL to Icons.Filled.Face,
    Category.EDUCATION to Icons.Filled.School,
    Category.ENTERTAINMENT to Icons.Filled.Celebration,
    Category.MUSIC to Icons.Filled.MusicNote,
    Category.VIDEO to Icons.Filled.Movie,
    Category.PHOTOGRAPHY to Icons.Filled.PhotoCamera,
    Category.HEALTH to Icons.Filled.FitnessCenter,
    Category.SPORTS to Icons.Filled.DirectionsRun,
    Category.NEWS to Icons.Filled.Newspaper,
    Category.BOOKS to Icons.Filled.MenuBook,
    Category.BUSINESS to Icons.Filled.BusinessCenter,
    Category.FINANCE to Icons.Filled.AccountBalance,
    Category.TRAVEL to Icons.Filled.Flight,
    Category.MAPS to Icons.Filled.Map,
    Category.FOOD to Icons.Filled.Restaurant,
    Category.SHOPPING to Icons.Filled.ShoppingCart,
    Category.UTILITIES to Icons.Filled.Email,
)

private val categoryColors: Map<Category, Color> = mapOf(
    Category.APP to Color(0xFF5C6BC0),
    Category.GAME to Color(0xFF7C4DFF),
    Category.PRODUCTIVITY to Color(0xFFF57C00),
    Category.SOCIAL to Color(0xFF0077FF),
    Category.EDUCATION to Color(0xFF00838F),
    Category.ENTERTAINMENT to Color(0xFF8E24AA),
    Category.MUSIC to Color(0xFFD81B60),
    Category.VIDEO to Color(0xFF1E88E5),
    Category.PHOTOGRAPHY to Color(0xFF6D4C41),
    Category.HEALTH to Color(0xFFE53935),
    Category.SPORTS to Color(0xFF2E7D32),
    Category.NEWS to Color(0xFF5D4037),
    Category.BOOKS to Color(0xFF455A64),
    Category.BUSINESS to Color(0xFF3949AB),
    Category.FINANCE to Color(0xFF00897B),
    Category.TRAVEL to Color(0xFF0288D1),
    Category.MAPS to Color(0xFF43A047),
    Category.FOOD to Color(0xFF7CB342),
    Category.SHOPPING to Color(0xFFEC407A),
    Category.UTILITIES to Color(0xFF616161),
)

internal fun mapCategory(raw: String): Category =
    categoryAliases[raw]
        ?: Category.entries.firstOrNull { it.title == raw }
        ?: Category.APP

internal fun categoryIcon(category: Category): ImageVector =
    categoryIcons.getValue(category)

internal fun categoryColor(category: Category): Color =
    categoryColors.getValue(category)

internal fun CatalogAppDto.toApp(): App = App(
    id = id,
    name = name,
    shortDescription = description,
    category = mapCategory(category),
    icon = categoryIcon(mapCategory(category)),
    iconContainer = categoryColor(mapCategory(category)),
    iconUrl = iconUrl,
)

internal fun AppDetailsDto.toAppDetails(): AppDetails {
    val mappedCategory = mapCategory(category)
    return AppDetails(
        id = id,
        name = name,
        developer = developer,
        category = mappedCategory,
        ageRating = ageRating,
        size = size.toFloat(),
        icon = categoryIcon(mappedCategory),
        iconContainer = categoryColor(mappedCategory),
        screenshotCount = screenshotUrlList?.size ?: 0,
        description = description,
    )
}
