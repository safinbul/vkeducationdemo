package com.example.vkeducationdemo.ui.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.vkeducationdemo.R
import com.example.vkeducationdemo.data.getAppDetails
import com.example.vkeducationdemo.data.getShowcaseApps
import kotlinx.coroutines.launch

@Composable
internal fun AppDetailsScreen(
    appId: Long,
    onBackClick: () -> Unit,
    onShowcaseAppClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val appDetails = remember(appId) { getAppDetails(appId) }
    val showcaseApps = remember(appId) { getShowcaseApps(appId) }
    var descriptionCollapsed by rememberSaveable { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val underDevelopmentText = stringResource(R.string.under_development)

    val showUnderDevelopmentMessage: () -> Unit = {
        scope.launch {
            snackbarHostState.showSnackbar(underDevelopmentText)
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = modifier.background(MaterialTheme.colorScheme.surface)
    ) { contentPadding ->
        AppDetailsContent(
            content = AppDetailsState.Content(
                appDetails = appDetails,
                showcaseApps = showcaseApps,
                descriptionCollapsed = descriptionCollapsed,
            ),
            onBackClick = onBackClick,
            onShareClick = showUnderDevelopmentMessage,
            onInstallClick = showUnderDevelopmentMessage,
            onReadMoreClick = { descriptionCollapsed = true },
            onDeveloperClick = showUnderDevelopmentMessage,
            onShowcaseAppClick = onShowcaseAppClick,
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(contentPadding),
        )
    }
}
