package com.example.vkeducationdemo.ui.applist

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkeducationdemo.R
import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.ui.theme.VKEducationDemoTheme
import kotlinx.coroutines.flow.Flow

@Composable
internal fun AppListScreen(
    onAppClick: (App) -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = viewModel.events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppListToolbar(onClick = viewModel::onToolbarClick) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp),
        ) {
            itemsIndexed(
                items = state.apps,
                key = { _, app -> app.id },
            ) { index, app ->
                AppListItem(
                    app = app,
                    onClick = { onAppClick(app) },
                )
                if (index != state.apps.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(start = 88.dp),
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    )
                }
            }
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
        AppListScreen(viewModel = AppListViewModel())
    }
}

@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AppListScreenDarkPreview() {
    VKEducationDemoTheme {
        AppListScreen(viewModel = AppListViewModel())
    }
}
