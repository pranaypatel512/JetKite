package com.pranay.jetkite.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.components.extension.JetKiteIconSize
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.designsystem.spacing

/**
 * An Back button that helps its users for back navigation from screen.
 * @param modifier the [Modifier] to be applied to this button
 * @param iconId paint resource id of icon
 * @param contentDescription icon content Description
 * @param onClick called when this button is clicked
 * */
@Composable
fun JetKiteBackButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int = JetKiteIcons.ArrowBack,
    contentDescription: String = "",
    onClick: () -> Unit = { }
) {
    IconButton(
        modifier = modifier
            .size(JetKiteIconSize.LargeButton)
            .padding(MaterialTheme.spacing.small),
        onClick = onClick
    ) {
        Icon(
            painterResource(id = iconId),
            contentDescription = contentDescription,
            modifier = Modifier.size(JetKiteIconSize.LargeButton)
        )
    }
}

@Composable
@Preview
fun JetKiteBackButtonPreview() {
    JetKiteBackButton(iconId = R.drawable.ic_arrow_back) {
    }
}
