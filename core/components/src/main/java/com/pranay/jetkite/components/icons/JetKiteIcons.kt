package com.pranay.jetkite.components.icons

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.pranay.jetkite.components.R

object JetKiteIcons {
    val ArrowBack = R.drawable.ic_arrow_back
    val JetKiteLogo = R.drawable.jetkitelogo
    val Login = R.drawable.ic_login
    val NewAccount = R.drawable.ic_person
    val Visibility = R.drawable.outline_visibility_24
    val VisibilityOff = R.drawable.outline_visibility_off_24
    val OtpSubmit = R.drawable.baseline_arrow_circle_up_24
    val UserPlaceholder = R.drawable.ic_user
    val BookmarkBorder = R.drawable.ic_nav_bookmark_border
    val Bookmark = R.drawable.ic_nav_bookmark
    val OrdersBorder = R.drawable.ic_nav_orders_border
    val Orders = R.drawable.ic_nav_orders
    val PortfolioBorder = R.drawable.ic_nav_portfolio_border
    val Portfolio = R.drawable.ic_nav_portfolio
    val ToolsBorder = R.drawable.ic_nav_settings_border
    val Tools = R.drawable.ic_nav_settings
    val ProfileBorder = R.drawable.ic_nav_profile_border
    val Profile = R.drawable.ic_nav_profile
    val Search = Icons.Default.Search
    val OrderPlaceholder = R.drawable.orders
    val PortfolioPlaceholder = R.drawable.portfolio
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
