package com.pranay.jetkite.dashboard.ui.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.pranay.jetkite.components.JetKiteTab
import com.pranay.jetkite.components.JetKiteTabRow
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.colorBackgroundUnSelected
import com.pranay.jetkite.designsystem.color_white
import com.pranay.jetkite.designsystem.spacing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalPagerApi::class)
@Composable
fun PortfolioScreen(
    modifier: Modifier = Modifier,
    viewModel: PortfolioViewModel = hiltViewModel(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onNavigationBackClick: () -> Unit = {}
) {
    val tabState by viewModel.tabState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(tabState.currentIndex)
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
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
                        counts = {
                            if (index == 0 && pagerState.currentPage == 0) {
                                Text(
                                    text = "15",
                                    color = color_white,
                                    style = MaterialTheme.typography.labelLarge
                                        .copy(textAlign = TextAlign.Center),
                                    modifier = Modifier.background(
                                        if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary,
                                        CircleShape
                                    ).padding(vertical = MaterialTheme.spacing.extraSmall, horizontal = MaterialTheme.spacing.dp6)
                                )
                            } else if (index == 0) {
                                Text(
                                    text = "15",
                                    color = color_white,
                                    style = MaterialTheme.typography.labelLarge
                                        .copy(textAlign = TextAlign.Center),
                                    modifier = Modifier.background(
                                        colorBackgroundUnSelected,
                                        CircleShape
                                    ).padding(vertical = MaterialTheme.spacing.extraSmall, horizontal = MaterialTheme.spacing.dp6)
                                )
                            }
                        }
                    ) {
                        Text(text = stringResource(id = titleId))
                    }
                }
            }
            HorizontalPager(
                count = tabState.titles.size,
                state = pagerState,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.weight(1f)
            ) { tabIndex ->
                when (tabIndex) {
                    0 -> {
                        HoldingsPage(
                            currentTab = tabIndex,
                            modifier = Modifier.fillMaxWidth()
                                .aspectRatio(1f)
                        )
                    }
                    1 -> {
                        PositionsPage(
                            currentTab = tabIndex,
                            modifier = Modifier.fillMaxWidth()
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        }
    }
}

@LightDarkPreviews
@Composable
fun PortfolioScreenPreview() {
    JetKiteTheme {
        PortfolioScreen()
    }
}
