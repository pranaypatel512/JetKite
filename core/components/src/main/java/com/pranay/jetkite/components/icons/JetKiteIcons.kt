package com.pranay.jetkite.components.icons

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.pranay.jetkite.components.R

object JetKiteIcons {
    val ArrowBack = R.drawable.ic_arrow_back
    val JetKiteLogo = R.drawable.jetkitelogo
    val Login = R.drawable.ic_login
    val NewAccount = R.drawable.ic_person
    val Visibility = R.drawable.outline_visibility_24
    val VisibilityOff = R.drawable.outline_visibility_off_24
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
