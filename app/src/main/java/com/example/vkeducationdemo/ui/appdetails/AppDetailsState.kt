package com.example.vkeducationdemo.ui.appdetails

import androidx.compose.runtime.Immutable
import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.domain.model.AppDetails

@Immutable
sealed interface AppDetailsState {
    data class Content(
        val appDetails: AppDetails,
        val showcaseApps: List<App>,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}
