package com.example.vkeducationdemo.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color
import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.domain.model.Category

internal val Apps: List<App> = listOf(
    App(
        id = 1L,
        name = "ВКонтакте",
        shortDescription = "Общение с друзьями, музыка, клипы и интересные сообщества",
        category = Category.SOCIAL,
        icon = Icons.Filled.Face,
        iconContainer = Color(0xFF0077FF),
    ),
    App(
        id = 2L,
        name = "RuStore",
        shortDescription = "Магазин приложений и игр для Android",
        category = Category.SHOPPING,
        icon = Icons.Filled.ShoppingCart,
        iconContainer = Color(0xFF7C4DFF),
    ),
    App(
        id = 3L,
        name = "Почта",
        shortDescription = "Письма, вложения и календарь в одном месте",
        category = Category.UTILITIES,
        icon = Icons.Filled.Email,
        iconContainer = Color(0xFF00897B),
    ),
    App(
        id = 4L,
        name = "Карты",
        shortDescription = "Навигация, пробки и популярные места рядом",
        category = Category.MAPS,
        icon = Icons.Filled.Map,
        iconContainer = Color(0xFF2E7D32),
    ),
    App(
        id = 5L,
        name = "Музыка",
        shortDescription = "Миллионы треков и подкастов, офлайн-режим",
        category = Category.MUSIC,
        icon = Icons.Filled.MusicNote,
        iconContainer = Color(0xFFD81B60),
    ),
    App(
        id = 6L,
        name = "Кинотеатр",
        shortDescription = "Фильмы и сериалы онлайн в HD-качестве",
        category = Category.VIDEO,
        icon = Icons.Filled.Movie,
        iconContainer = Color(0xFF1E88E5),
    ),
    App(
        id = 7L,
        name = "Заметки",
        shortDescription = "Быстрые заметки, списки дел и напоминания",
        category = Category.PRODUCTIVITY,
        icon = Icons.Filled.Note,
        iconContainer = Color(0xFFF57C00),
    ),
    App(
        id = 8L,
        name = "Фитнес",
        shortDescription = "Тренировки, шагомер и дневник активности",
        category = Category.HEALTH,
        icon = Icons.Filled.FitnessCenter,
        iconContainer = Color(0xFFE53935),
    ),
    App(
        id = 9L,
        name = "Новости",
        shortDescription = "Главные события дня и персональные рекомендации",
        category = Category.NEWS,
        icon = Icons.Filled.Newspaper,
        iconContainer = Color(0xFF5D4037),
    ),
    App(
        id = 10L,
        name = "Банк",
        shortDescription = "Переводы, платежи и аналитика расходов",
        category = Category.FINANCE,
        icon = Icons.Filled.AccountBalance,
        iconContainer = Color(0xFF3949AB),
    ),
    App(
        id = 11L,
        name = "Онлайн-курсы",
        shortDescription = "Видеоуроки и тесты по программированию",
        category = Category.EDUCATION,
        icon = Icons.Filled.School,
        iconContainer = Color(0xFF00838F),
    ),
    App(
        id = 12L,
        name = "Еда",
        shortDescription = "Доставка из ресторанов и кафе рядом",
        category = Category.FOOD,
        icon = Icons.Filled.Restaurant,
        iconContainer = Color(0xFF7CB342),
    ),
)
