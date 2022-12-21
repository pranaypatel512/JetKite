package com.pranay.jetkite.dashboard.ui.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.zIndex
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.JetKiteTextViewPnL
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.extension.colorValue
import com.pranay.jetkite.components.extension.toDisplayValue
import com.pranay.jetkite.components.extension.topSectionBackgroundColor
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.dashboard.R
import com.pranay.jetkite.dashboard.ui.orders.OrderPlaceholder
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.colorSearchBackground
import com.pranay.jetkite.designsystem.colorSearchTextDark
import com.pranay.jetkite.designsystem.colorSearchTextLight
import com.pranay.jetkite.designsystem.color_white
import com.pranay.jetkite.designsystem.spacing

@Composable
fun PositionsPage(
    currentTab: Int,
    modifier: Modifier = Modifier,
    showPlaceholder: Boolean = false,
    textColor: Color = if (isSystemInDarkTheme()) colorSearchTextDark else colorSearchTextLight,
    backgroundColor: Color = if (isSystemInDarkTheme()) colorSearchBackground else color_white
) {
    val showPnL = remember { mutableStateOf(false) }
    val pnLValue = remember { mutableStateOf(21.43f) }
    val textLabel = remember { mutableStateOf(if (showPnL.value) "Total P&L" else "No positions") }
    Box(
        modifier = modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            // Divider(thickness = MaterialTheme.spacing.medium, color = topSectionBackgroundColor())
            val boxHeight = MaterialTheme.spacing.dp100
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height(boxHeight).background(
                    MaterialTheme.colorScheme.surface
                )
            ) {
                Surface(
                    modifier = Modifier.zIndex(10f).padding(horizontal = MaterialTheme.spacing.dp12).fillMaxWidth(),
                    shape = RoundedCornerShape(MaterialTheme.spacing.extraSmall),
                    color = backgroundColor,
                    shadowElevation = MaterialTheme.spacing.extraSmall
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
                        JetKiteTextView(
                            modifier = Modifier.fillMaxWidth(),
                            text = textLabel.value,
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.outline, textAlign = TextAlign.Center)
                        )
                        if (showPnL.value) {
                            JetKiteTextViewPnL(
                                text = pnLValue.value.toDisplayValue(),
                                color = pnLValue.value.colorValue(),
                                style = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
                                modifier = Modifier.padding(top = MaterialTheme.spacing.extraSmall)
                            )
                        }
                    }
                }
                Divider(Modifier.fillMaxWidth().height(boxHeight / 2).align(Alignment.TopCenter), color = topSectionBackgroundColor())
            }
        }
        if (!showPnL.value) {
            OrderPlaceholder(
                placeholderTitle = stringResource(id = R.string.str_no_positions_order),
                placeholderSubTitle = stringResource(id = R.string.str_no_executed_order_subtitle),
                placeholderIcon = Icon.DrawableResourceIcon(JetKiteIcons.PortfolioPlaceholder),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@LightDarkPreviews
@Composable
fun PositionsPagePreview() {
    JetKiteTheme {
        PositionsPage(0)
    }
}
