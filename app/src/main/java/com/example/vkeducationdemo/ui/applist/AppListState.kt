package com.example.vkeducationdemo.ui.applist

import androidx.compose.runtime.Immutable
import com.example.vkeducationdemo.domain.model.App

@Immutable
data class AppListState(
    val apps: List<App> = emptyList(),
)
