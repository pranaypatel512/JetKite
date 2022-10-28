package com.pranay.jetkite.components.icons

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.pranay.jetkite.components.R

object JetKiteIcons {
    val ArrowBack = Icons.Rounded.ArrowBack
    val JetKiteLogo = R.drawable.jetkitelogo
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
