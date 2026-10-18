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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkeducationdemo.data.Apps
import com.example.vkeducationdemo.ui.theme.VKEducationDemoTheme

@Composable
internal fun AppListScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppListToolbar() },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(top = 8.dp, bottom = 16.dp),
        ) {
            itemsIndexed(
                items = Apps,
                key = { _, app -> app.id },
            ) { index, app ->
                AppListItem(app = app)
                if (index != Apps.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(start = 88.dp),
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    )
                }
            }
        }
    }
}

@Preview(name = "Light", showBackground = true)
@Composable
private fun AppListScreenLightPreview() {
    VKEducationDemoTheme {
        AppListScreen()
    }
}

@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AppListScreenDarkPreview() {
    VKEducationDemoTheme {
        AppListScreen()
    }
}
