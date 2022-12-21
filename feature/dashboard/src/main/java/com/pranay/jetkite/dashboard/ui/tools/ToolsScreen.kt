package com.pranay.jetkite.dashboard.ui.tools

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.pranay.jetkite.components.JetKiteTab
import com.pranay.jetkite.components.JetKiteTabRow
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.dashboard.R
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.colorSearchBackground
import com.pranay.jetkite.designsystem.colorSearchTextDark
import com.pranay.jetkite.designsystem.colorSearchTextLight
import com.pranay.jetkite.designsystem.color_white
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalPagerApi::class)
@Composable
fun ToolsScreen(
    modifier: Modifier = Modifier,
    viewModel: ToolsScreenViewModel = hiltViewModel(),
    placeholderText: String? = null,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onNewOptionClick: (CreateNewCase) -> Unit = {},
    onNavigationBackClick: () -> Unit = {},
    textNewBasketLabel: String = stringResource(id = R.string.str_new_basket),
    backgroundColor: Color = if (isSystemInDarkTheme()) colorSearchBackground else color_white,
    textColor: Color = if (isSystemInDarkTheme()) colorSearchTextDark else colorSearchTextLight
) {
    val tabState by viewModel.tabState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(tabState.currentIndex)
    Surface {
        Column(modifier) {
            JetKiteTabRow(selectedTabIndex = pagerState.currentPage, pagerState = pagerState, scrollable = false) {
                tabState.titles.forEachIndexed { index, titleId ->
                    JetKiteTab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                            viewModel.switchTab(index)
                        }
                    ) { Text(text = stringResource(id = titleId)) }
                }
            }
            HorizontalPager(count = tabState.titles.size, state = pagerState) { tabIndex ->
                val newTextLabel = when (tabIndex) {
                    1 -> { stringResource(id = R.string.new_sip) }
                    2 -> { stringResource(id = R.string.new_alert) }
                    else -> { stringResource(id = R.string.str_new_basket) }
                }
                val textPlaceholder = when (tabIndex) {
                    1 -> { stringResource(id = R.string.search_sip) }
                    2 -> { stringResource(id = R.string.search_alerts) }
                    else -> { stringResource(id = R.string.search_basket) }
                }
                ToolsPage(
                    currentTab = tabIndex,
                    textNewBasketLabel = newTextLabel,
                    placeholderText = textPlaceholder,
                    onValueChange = {
                    },
                    onNewItemClick = {
                        when (tabIndex) {
                            1 -> {
                                // open screen for new SIP
                            }

                            2 -> {
                                // Open screen for new Alert
                            }

                            else -> {
                                // open screen for new basket
                            }
                        }
                    }
                )
            }
        }
    }
}

@LightDarkPreviews
@Composable
fun ToolsScreenPreview() {
    JetKiteTheme {
        ToolsScreen()
    }
}
