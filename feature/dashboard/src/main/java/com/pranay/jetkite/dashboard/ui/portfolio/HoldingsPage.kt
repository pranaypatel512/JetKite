package com.pranay.jetkite.dashboard.ui.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.pranay.jetkite.components.extension.topSectionBackgroundColor
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.dashboard.R
import com.pranay.jetkite.dashboard.ui.orders.OrderPlaceholder
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.colorGreen
import com.pranay.jetkite.designsystem.colorRed
import com.pranay.jetkite.designsystem.colorSearchBackground
import com.pranay.jetkite.designsystem.colorSearchTextDark
import com.pranay.jetkite.designsystem.colorSearchTextLight
import com.pranay.jetkite.designsystem.color_white
import com.pranay.jetkite.designsystem.spacing

@Composable
fun HoldingsPage(
    currentTab: Int,
    modifier: Modifier = Modifier,
    showPlaceholder: Boolean = false,
    textColor: Color = if (isSystemInDarkTheme()) colorSearchTextDark else colorSearchTextLight,
    backgroundColor: Color = if (isSystemInDarkTheme()) colorSearchBackground else color_white
) {
    val showHoldings = remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxHeight()
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Divider(thickness = MaterialTheme.spacing.medium, color = topSectionBackgroundColor())
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.wrapContentHeight().background(
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
                        Row {
                            SectionAmountsWithLabel("Invested", "1,00,000", modifier = Modifier.weight(1f))
                            SectionAmountsWithLabel("Current", "3,00,000", modifier = Modifier.weight(1f))
                        }
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = MaterialTheme.spacing.dp12, vertical = MaterialTheme.spacing.extraSmall)
                                .height(MaterialTheme.spacing.dp1),
                            color = textColor.copy(alpha = 0.2f)
                        )
                        SectionPnL("2,00,000", "+15.25%", modifier = Modifier.fillMaxWidth())
                    }
                }
                Divider(Modifier.fillMaxWidth().fillMaxHeight(0.165f).align(Alignment.TopCenter), color = topSectionBackgroundColor())
            }
        }
        if (!showHoldings.value) {
            OrderPlaceholder(
                placeholderTitle = stringResource(id = R.string.str_no_holdings_order),
                placeholderSubTitle = stringResource(id = R.string.str_no_holdings_info),
                placeholderIcon = Icon.DrawableResourceIcon(JetKiteIcons.PortfolioPlaceholder),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun SectionAmountsWithLabel(textLabel: String, textValue: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        JetKiteTextView(
            modifier = Modifier.fillMaxWidth(),
            text = textLabel,
            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.outline, textAlign = TextAlign.Start)
        )
        JetKiteTextView(
            text = textValue,
            style = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Start),
            modifier = Modifier.fillMaxWidth().padding(bottom = MaterialTheme.spacing.dp12, top = MaterialTheme.spacing.extraSmall)
        )
    }
}

@Composable
fun SectionPnL(textLabel: String, textValue: String, modifier: Modifier = Modifier, isInLoss: Boolean = false) {
    val colorOfPnL = remember { mutableStateOf(if (isInLoss) colorRed else colorGreen) }
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        JetKiteTextView(
            modifier = Modifier.weight(1f).padding(top = MaterialTheme.spacing.dp12, bottom = MaterialTheme.spacing.extraSmall),
            text = stringResource(id = R.string.str_pnl),
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.outline, textAlign = TextAlign.Start)
        )
        Row(modifier = Modifier.weight(1f).padding(top = MaterialTheme.spacing.dp12, bottom = MaterialTheme.spacing.extraSmall), verticalAlignment = Alignment.CenterVertically) {
            JetKiteTextView(
                text = textLabel,
                style = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Start, color = colorOfPnL.value)
            )
            JetKiteTextViewPnL(
                text = textValue,
                color = colorOfPnL.value,
                style = MaterialTheme.typography.bodySmall.copy(textAlign = TextAlign.Start),
                modifier = Modifier.padding(start = MaterialTheme.spacing.extraSmall)
            )
        }
    }
}

@LightDarkPreviews
@Composable
fun HoldingsPagePreview() {
    JetKiteTheme {
        HoldingsPage(0)
    }
}

@LightDarkPreviews
@Composable
fun SectionAmountsWithLabelPreview() {
    JetKiteTheme {
        SectionAmountsWithLabel("Invested", "1,22,222")
    }
}

@LightDarkPreviews
@Composable
fun SectionPnLPreview() {
    JetKiteTheme {
        SectionPnL("Invested", "1,22,222")
    }
}
