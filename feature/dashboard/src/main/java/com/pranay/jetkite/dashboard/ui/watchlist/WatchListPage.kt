package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.extension.topSectionBackgroundColor
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun WatchListPage(currentTab: Int, modifier: Modifier = Modifier) {
    Surface {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val boxHeight = MaterialTheme.spacing.dp100
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height(boxHeight).background(
                    MaterialTheme.colorScheme.surface
                )
            ) {
                Divider(Modifier.fillMaxWidth().height(boxHeight / 2).align(Alignment.TopCenter), color = topSectionBackgroundColor())
                WatchListSearch(
                    onFilterClick = { },
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth().zIndex(10f).padding(horizontal = MaterialTheme.spacing.medium).align(
                        Alignment.Center
                    )
                )
            }
            val tabPage = currentTab + 1
            JetKiteTextView(
                text = "Watchlist page($tabPage)",
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@LightDarkPreviews
@Composable
fun WatchListPagePreview() {
    JetKiteTheme {
        WatchListPage(0)
    }
}
