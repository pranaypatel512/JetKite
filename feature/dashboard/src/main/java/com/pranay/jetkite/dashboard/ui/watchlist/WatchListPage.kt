package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.designsystem.JetKiteTheme

@Composable
fun WatchListPage(currentTab: Int, modifier: Modifier = Modifier) {
    Surface {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
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
