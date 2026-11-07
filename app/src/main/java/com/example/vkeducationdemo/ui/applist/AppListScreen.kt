package com.example.vkeducationdemo.ui.applist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vkeducationdemo.R
import com.example.vkeducationdemo.data.Apps
import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.ui.theme.VKEducationDemoTheme
import kotlinx.coroutines.flow.Flow

@Composable
internal fun AppListScreen(
    onAppClick: (App) -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = viewModel.events,
        snackbarHostState = snackbarHostState,
    )

    AppListContent(
        state = state,
        onToolbarClick = viewModel::onToolbarClick,
        onRetryClick = viewModel::load,
        onAppClick = onAppClick,
        snackbarHostState = snackbarHostState,
        modifier = modifier,
    )
}

@Composable
internal fun AppListContent(
    state: AppListState,
    onToolbarClick: () -> Unit,
    onRetryClick: () -> Unit,
    onAppClick: (App) -> Unit,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppListToolbar(onClick = onToolbarClick) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        when (state) {
            is AppListState.Loading -> {
                AppListLoading(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                )
            }

            is AppListState.Error -> {
                AppListError(
                    onRetryClick = onRetryClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                )
            }

            is AppListState.Content -> {
                AppList(
                    apps = state.apps,
                    onAppClick = onAppClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                )
            }
        }
    }
}

@Composable
private fun AppList(
    apps: List<App>,
    onAppClick: (App) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp),
    ) {
        itemsIndexed(
            items = apps,
            key = { _, app -> app.id },
        ) { index, app ->
            AppListItem(
                app = app,
                onClick = { onAppClick(app) },
            )
            if (index != apps.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(start = 88.dp),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                )
            }
        }
    }
}

@Composable
internal fun AppListLoading(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
internal fun AppListError(
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.app_list_error),
            fontStyle = MaterialTheme.typography.headlineMedium.fontStyle,
        )
        Spacer(Modifier.height(12.dp))
        Button(onClick = onRetryClick) {
            Text(text = stringResource(R.string.app_list_refresh))
        }
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppListEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val toolbarClickedText = stringResource(R.string.app_list_toolbar_clicked)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppListEvent.ToolbarClicked -> {
                    snackbarHostState.showSnackbar(toolbarClickedText)
                }
            }
        }
    }
}

@Preview(name = "Light", showBackground = true)
@Composable
private fun AppListScreenLightPreview() {
    VKEducationDemoTheme {
        AppListContent(
            state = AppListState.Content(apps = Apps),
            onToolbarClick = {},
            onRetryClick = {},
            onAppClick = {},
            snackbarHostState = remember { SnackbarHostState() },
        )
    }
}

@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AppListScreenDarkPreview() {
    VKEducationDemoTheme {
        AppListContent(
            state = AppListState.Content(apps = Apps),
            onToolbarClick = {},
            onRetryClick = {},
            onAppClick = {},
            snackbarHostState = remember { SnackbarHostState() },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListLoadingPreview() {
    VKEducationDemoTheme {
        AppListContent(
            state = AppListState.Loading,
            onToolbarClick = {},
            onRetryClick = {},
            onAppClick = {},
            snackbarHostState = remember { SnackbarHostState() },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListErrorPreview() {
    VKEducationDemoTheme {
        AppListContent(
            state = AppListState.Error,
            onToolbarClick = {},
            onRetryClick = {},
            onAppClick = {},
            snackbarHostState = remember { SnackbarHostState() },
        )
    }
}
