package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pranay.jetkite.components.JetKiteTab
import com.pranay.jetkite.components.JetKiteTabRow
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.designsystem.JetKiteTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier,
    viewModel: WatchListViewModel = hiltViewModel(),
    onNavigationBackClick: () -> Unit = {}
) {
    val tabState by viewModel.tabState.collectAsStateWithLifecycle()

    Surface {
        WatchListContent(tabState = tabState, switchTab = viewModel::switchTab)
    }
}

@Composable
private fun WatchListContent(
    tabState: WatchListTabState,
    switchTab: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        JetKiteTabRow(selectedTabIndex = tabState.currentIndex) {
            tabState.titles.forEachIndexed { index, titleId ->
                JetKiteTab(
                    selected = index == tabState.currentIndex,
                    onClick = { switchTab(index) },
                    text = { Text(text = stringResource(id = titleId)) }
                )
            }
        }
        WatchListPage(currentTab = tabState.currentIndex)
    }
}

@LightDarkPreviews
@Composable
fun WatchListScreenPreview() {
    JetKiteTheme {
        WatchListScreen()
    }
}
