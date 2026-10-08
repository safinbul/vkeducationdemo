package com.example.vkeducationdemo.utils

private val PHONE_REGEX = Regex("^\\+?[0-9\\s()\\-]{5,15}$")

fun validateNotEmpty(text: String): String? =
    if (text.isBlank()) "Поле не должно быть пустым" else null

fun validatePhone(phone: String): String? = when {
    phone.isBlank() -> "Введите номер телефона"
    !PHONE_REGEX.matches(phone) -> "Некорректный номер телефона"
    else -> null
}