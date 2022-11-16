package com.pranay.jetkite.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class Spacing internal constructor(
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val minWidth: Dp = 300.dp,
    val smallImage: Dp = 32.dp,
    val mediumImage: Dp = 52.dp,
    val largeImage: Dp = 120.dp,
    val dp100: Dp = 100.dp,
    val dp50: Dp = 50.dp,
    val dp80: Dp = 80.dp,
    val dp60: Dp = 60.dp,
    val dp20: Dp = 20.dp,
    val dp1: Dp = 1.dp,
    val dp12: Dp = 12.dp
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Spacing) return false

        if (extraSmall != other.extraSmall) return false
        if (small != other.small) return false
        if (medium != other.medium) return false
        if (large != other.large) return false
        if (extraLarge != other.extraLarge) return false
        if (minWidth != other.minWidth) return false

        return true
    }

    override fun hashCode(): Int {
        var result = extraSmall.hashCode()
        result = 31 * result + small.hashCode()
        result = 31 * result + medium.hashCode()
        result = 31 * result + large.hashCode()
        result = 31 * result + extraLarge.hashCode()
        result = 31 * result + minWidth.hashCode()
        return result
    }

    override fun toString(): String {
        return "Spacing(extraSmall=$extraSmall, small=$small, medium=$medium," +
            " large=$large, extraLarge=$extraLarge, minWidth=$minWidth)"
    }
}

/**
 * Retrieves the current [Spacing] at the call site's position in the hierarchy.
 */
val MaterialTheme.spacing
    @Composable
    @ReadOnlyComposable
    get() = staticCompositionLocalOf { Spacing() }.current
