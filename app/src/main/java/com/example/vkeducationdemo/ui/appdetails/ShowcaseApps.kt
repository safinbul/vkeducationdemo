package com.example.vkeducationdemo.ui.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkeducationdemo.R
import com.example.vkeducationdemo.data.SHOWCASE_PAGE_COUNT
import com.example.vkeducationdemo.data.SHOWCASE_PAGE_SIZE
import com.example.vkeducationdemo.data.getShowcaseApps
import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.ui.applist.AppListItem
import com.example.vkeducationdemo.ui.theme.VKEducationDemoTheme

@Composable
internal fun ShowcaseApps(
    apps: List<App>,
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.showcase_title),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(4.dp))
        HorizontalPager(
            state = rememberPagerState(pageCount = { SHOWCASE_PAGE_COUNT }),
            pageSpacing = 8.dp,
            modifier = Modifier.fillMaxWidth(),
        ) { page ->
            Column {
                val pageApps = apps.chunked(SHOWCASE_PAGE_SIZE)[page]
                pageApps.forEachIndexed { index, app ->
                    AppListItem(app = app, onClick = onAppClick)
                    if (index != pageApps.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(start = 88.dp),
                            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VKEducationDemoTheme {
        ShowcaseApps(
            apps = getShowcaseApps(1L),
            onAppClick = {},
        )
    }
}
