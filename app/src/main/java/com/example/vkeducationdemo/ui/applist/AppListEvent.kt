package com.example.vkeducationdemo.ui.applist

sealed interface AppListEvent {
    data object ToolbarClicked : AppListEvent
}
