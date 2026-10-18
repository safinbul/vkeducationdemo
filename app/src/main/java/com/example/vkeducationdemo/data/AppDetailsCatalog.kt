package com.example.vkeducationdemo.data

import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.domain.model.AppDetails

internal const val SHOWCASE_PAGE_COUNT = 3
internal const val SHOWCASE_PAGE_SIZE = 3

private fun App.toAppDetails(
    developer: String,
    ageRating: Int,
    size: Float,
    description: String,
) = AppDetails(
    id = id,
    name = name,
    developer = developer,
    category = category,
    ageRating = ageRating,
    size = size,
    icon = icon,
    iconContainer = iconContainer,
    screenshotCount = 4,
    description = description,
)

private val HardcodedAppDetails: Map<Long, AppDetails> = listOf(
    Apps[0].toAppDetails(
        developer = "VK",
        ageRating = 3,
        size = 96.4f,
        description = "ВКонтакте — универсальное приложение для общения: сообщения, звонки, музыка, " +
            "клипы, лента новостей и сообщества по интересам. Обновления статуса, истории, " +
            "переводы друзьям и тёмная тема в одном приложении.",
    ),
    Apps[1].toAppDetails(
        developer = "RuStore",
        ageRating = 3,
        size = 58.2f,
        description = "RuStore — магазин приложений и игр для Android. Безопасная установка, " +
            "автообновления, оплата российскими картами и рекомендации на основе ваших " +
            "предпочтений.",
    ),
    Apps[2].toAppDetails(
        developer = "VK Tech",
        ageRating = 3,
        size = 74.1f,
        description = "Почта — быстрая и удобная работа с письмами. Единый ящик для всех адресов, " +
            "умные фильтры спама, календарь и напоминания, офлайн-чтение писем.",
    ),
    Apps[3].toAppDetails(
        developer = "VK Maps",
        ageRating = 0,
        size = 120.5f,
        description = "Карты — навигация по городу и миру. Голосовые подсказки, информация о " +
            "пробках, обзорные маршруты, справочник организаций и отзывы пользователей.",
    ),
    Apps[4].toAppDetails(
        developer = "VK Музыка",
        ageRating = 12,
        size = 45.8f,
        description = "Музыка — миллионы треков и подкастов. Персональные подборки, плейлисты " +
            "друзей, умный офлайн-режим и синхронизация между устройствами.",
    ),
    Apps[5].toAppDetails(
        developer = "VK Видео",
        ageRating = 16,
        size = 89.9f,
        description = "Кинотеатр — фильмы и сериалы онлайн в HD. Своя коллекция, продолжение " +
            "просмотра на любом устройстве, детский профиль и родительский контроль.",
    ),
    Apps[6].toAppDetails(
        developer = "VK Education",
        ageRating = 3,
        size = 18.3f,
        description = "Заметки — простой редактор для быстрых мыслей и дел. Списки покупок, " +
            "чек-листы, напоминания и синхронизация без регистрации.",
    ),
    Apps[7].toAppDetails(
        developer = "VK Health",
        ageRating = 0,
        size = 64.7f,
        description = "Фитнес — тренер в вашем кармане. Готовые программы тренировок, шагомер, " +
            "дневник активности и статистика прогресса за неделю.",
    ),
    Apps[8].toAppDetails(
        developer = "VK News",
        ageRating = 12,
        size = 39.2f,
        description = "Новости — главные события дня в удобном формате. Персональная лента, " +
            "темы по интересам, офлайн-чтение и уведомления о важных событиях.",
    ),
    Apps[9].toAppDetails(
        developer = "VK Pay",
        ageRating = 3,
        size = 132.6f,
        description = "Банк — платежи и переводы без комиссии. Аналитика расходов, кэшбэк, " +
            "автоплатежи и безопасные онлайн-покупки.",
    ),
    Apps[10].toAppDetails(
        developer = "VK Education",
        ageRating = 6,
        size = 27.5f,
        description = "Онлайн-курсы — программирование с нуля до профессии. Видеоуроки, " +
            "интерактивные тесты, проверка заданий и сертификаты по завершении.",
    ),
    Apps[11].toAppDetails(
        developer = "VK Food",
        ageRating = 0,
        size = 51.0f,
        description = "Еда — доставка из ресторанов и кафе рядом. Промокоды и акции, отслеживание " +
            "курьера на карте и повторение прошлых заказов в один тап.",
    ),
).associateBy { it.id }

internal fun getAppDetails(appId: Long): AppDetails =
    HardcodedAppDetails[appId] ?: HardcodedAppDetails.getValue(Apps[0].id)

internal fun getShowcaseApps(currentAppId: Long): List<App> =
    Apps.filter { it.id != currentAppId }.take(SHOWCASE_PAGE_COUNT * SHOWCASE_PAGE_SIZE)
