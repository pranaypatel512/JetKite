package com.pranay.jetkite.components.extension

import android.annotation.SuppressLint
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pranay.jetkite.designsystem.colorGreen
import com.pranay.jetkite.designsystem.colorRed
import com.pranay.jetkite.designsystem.colorTopSectionBackgroundDark
import com.pranay.jetkite.designsystem.colorTopSectionBackgroundLight

@Composable
fun SystemBarsPaddingSpacer(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.systemBarsPadding())
}

/* ktlint-disable twitter-compose:modifier-composable-check */
@SuppressLint("ComposableModifierFactory")
@Composable
fun Modifier.clickableWithRipple( // ktlint-disable modifier-composable-check
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication = rememberRipple(),
    onClick: () -> Unit
) = clickable(
    interactionSource = interactionSource,
    indication = indication,
    onClick = onClick
)
/* ktlint-enable twitter-compose:modifier-composable-check */

@Composable
fun topSectionBackgroundColor(): Color {
    return if (isSystemInDarkTheme()) colorTopSectionBackgroundDark else colorTopSectionBackgroundLight
}

@Composable
fun Float.colorValue(): Color {
    return if (this.isPositive()) colorGreen else colorRed
}
