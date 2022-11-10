package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.components.extension.SystemBarsPaddingSpacer
import com.pranay.jetkite.designsystem.JetKiteTheme

@Composable
fun WatchListPage(currentTab: Int) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SystemBarsPaddingSpacer()
            val tabPage = currentTab + 1
            JetKiteTextView(
                text = "Watchlist page($tabPage)",
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@LightDarkPreview
@Composable
fun WatchListPagePreview() {
    JetKiteTheme {
        WatchListPage(0)
    }
}
