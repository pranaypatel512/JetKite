package com.pranay.jetkite.dashboard.ui.tools

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.zIndex
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.extension.topSectionBackgroundColor
import com.pranay.jetkite.dashboard.R
import com.pranay.jetkite.dashboard.ui.watchlist.WatchListSearch
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun ToolsPage(
    currentTab: Int,
    textNewBasketLabel: String,
    placeholderText: String,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    onNewItemClick: () -> Unit
) {
    Surface {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val boxHeight = MaterialTheme.spacing.dp100
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(boxHeight)
                    .background(
                        MaterialTheme.colorScheme.surface
                    )
            ) {
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .height(boxHeight / 2)
                        .align(Alignment.TopCenter),
                    color = topSectionBackgroundColor()
                )
                WatchListSearch(
                    onValueChange = onValueChange,
                    onNewBasketClick = onNewItemClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(10f)
                        .padding(horizontal = MaterialTheme.spacing.medium)
                        .align(
                            Alignment.Center
                        ),
                    showFilter = false,
                    showNewBasket = true,
                    textNewBasketLabel = textNewBasketLabel,
                    placeholderText = placeholderText
                )
            }
        }
    }
}

@LightDarkPreviews
@Composable
fun ToolsPagePreview() {
    JetKiteTheme {
        val newTextLabel = stringResource(id = R.string.str_new_basket)
        val textPlaceholder = stringResource(id = R.string.search_basket)
        ToolsPage(
            currentTab = 0,
            textNewBasketLabel = newTextLabel,
            placeholderText = textPlaceholder,
            onValueChange = {
            },
            onNewItemClick = {
            }
        )
    }
}
