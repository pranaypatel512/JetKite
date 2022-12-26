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
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.components.icons.JetKiteIcons
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
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onNewOptionClick: (CreateNewCase) -> Unit = {},
    onNavigationBackClick: () -> Unit = {},
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
                val toolsPageInfo = when (tabIndex) {
                    1 -> {
                        ToolsPageInfo(
                            newOptionText = stringResource(id = R.string.new_sip),
                            searchPlaceHolder = stringResource(id = R.string.search_sip),
                            placeHolderTitle = stringResource(id = R.string.new_no_sip),
                            placeHolderSubTitle = stringResource(id = R.string.new_create_sip),
                            Icon.DrawableResourceIcon(JetKiteIcons.ToolsSIPPlaceholder)
                        )
                    }
                    2 -> {
                        ToolsPageInfo(
                            newOptionText = stringResource(id = R.string.new_alert),
                            searchPlaceHolder = stringResource(id = R.string.search_alerts),
                            placeHolderTitle = stringResource(id = R.string.new_no_alert),
                            placeHolderSubTitle = stringResource(id = R.string.new_create_alert),
                            Icon.DrawableResourceIcon(JetKiteIcons.ToolsAlertPlaceholder)
                        )
                    }
                    else -> {
                        ToolsPageInfo(
                            newOptionText = stringResource(id = R.string.str_new_basket),
                            searchPlaceHolder = stringResource(id = R.string.search_basket),
                            placeHolderTitle = stringResource(id = R.string.str_no_basket),
                            placeHolderSubTitle = stringResource(id = R.string.str_create_basket),
                            Icon.DrawableResourceIcon(JetKiteIcons.ToolsBasketPlaceholder)
                        )
                    }
                }
                ToolsPage(
                    currentTab = tabIndex,
                    pageInfo = toolsPageInfo,
                    onValueChange = {
                    },
                    onNewItemClick = {
                        when (tabIndex) {
                            1 -> {
                                // open screen for new SIP
                                onNewOptionClick.invoke(CreateNewCase.CreateNewSIP)
                            }

                            2 -> {
                                // Open screen for new Alert
                                onNewOptionClick.invoke(CreateNewCase.CreateNewAlert)
                            }

                            else -> {
                                // open screen for new basket
                                onNewOptionClick.invoke(CreateNewCase.CreateNewBasket)
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
