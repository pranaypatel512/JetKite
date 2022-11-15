package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.pranay.jetkite.components.JetKiteTab
import com.pranay.jetkite.components.JetKiteTabRow
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.designsystem.JetKiteTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalPagerApi::class)
@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier,
    viewModel: WatchListViewModel = hiltViewModel(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onNavigationBackClick: () -> Unit = {}
) {
    val tabState by viewModel.tabState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(tabState.currentIndex)
    Surface {
        Column(modifier) {
            JetKiteTabRow(selectedTabIndex = pagerState.currentPage, pagerState = pagerState) {
                tabState.titles.forEachIndexed { index, titleId ->
                    JetKiteTab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                            viewModel.switchTab(index)
                        },
                        text = { Text(text = stringResource(id = titleId)) }
                    )
                }
            }
            HorizontalPager(count = tabState.titles.size, state = pagerState) { tabIndex ->
                WatchListPage(currentTab = tabIndex)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun WatchListContent(
    tabState: WatchListTabState,
    pagerState: PagerState,
    switchTab: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        JetKiteTabRow(selectedTabIndex = pagerState.currentPage, pagerState = pagerState) {
            tabState.titles.forEachIndexed { index, titleId ->
                JetKiteTab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        // switchTab(index)
                    },
                    text = { Text(text = stringResource(id = titleId)) }
                )
            }
        }
        HorizontalPager(count = tabState.titles.size, state = pagerState) { tabIndex ->
            WatchListPage(currentTab = tabIndex)
        }
    }
}

@LightDarkPreviews
@Composable
fun WatchListScreenPreview() {
    JetKiteTheme {
        WatchListScreen()
    }
}
