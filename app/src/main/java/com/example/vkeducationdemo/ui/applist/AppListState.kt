package com.example.vkeducationdemo.ui.applist

import androidx.compose.runtime.Immutable
import com.example.vkeducationdemo.domain.model.App

@Immutable
sealed interface AppListState {
    data object Loading : AppListState
    data object Error : AppListState
    data class Content(
        val apps: List<App>,
    ) : AppListState
}
