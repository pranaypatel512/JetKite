package com.pranay.jetkite.dashboard.ui.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.zIndex
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.extension.topSectionBackgroundColor
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.dashboard.R
import com.pranay.jetkite.dashboard.ui.watchlist.WatchListSearch
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun OrderPage(
    currentTab: Int,
    modifier: Modifier = Modifier,
    showPlaceholder: Boolean = false
) {
    Surface() {
        Box(modifier = modifier.fillMaxHeight()) {
            when (currentTab) {
                0 -> {
                    OrderPlaceholder(
                        placeholderTitle = stringResource(id = R.string.str_no_open_order),
                        placeholderSubTitle = stringResource(id = R.string.str_no_executed_order_subtitle),
                        placeholderIcon = Icon.DrawableResourceIcon(JetKiteIcons.OrderPlaceholder),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                1 -> {
                    OrderPlaceholder(
                        placeholderTitle = stringResource(id = R.string.str_no_executed_order),
                        placeholderSubTitle = stringResource(id = R.string.str_no_executed_order_subtitle),
                        placeholderIcon = Icon.DrawableResourceIcon(JetKiteIcons.OrderPlaceholder),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            Column(
                modifier = Modifier.align(Alignment.TopCenter)
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
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth().zIndex(10f).padding(horizontal = MaterialTheme.spacing.medium).align(
                            Alignment.Center
                        ),
                        placeholderText = stringResource(id = R.string.str_search_order)
                    )
                }
            }
        }
    }
}

@LightDarkPreviews
@Composable
fun OrderPagePreview() {
    JetKiteTheme {
        OrderPage(0)
    }
}
