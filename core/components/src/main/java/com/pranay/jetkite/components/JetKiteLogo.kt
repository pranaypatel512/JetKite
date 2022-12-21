package com.pranay.jetkite.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.components.icons.JetKiteIcons

@Composable
fun JetKiteLogo(
    modifier: Modifier = Modifier,
    imageRes: Int = JetKiteIcons.JetKiteLogo,
    onImageClick: () -> Unit = {}
) {
    Image(
        modifier = modifier.clickable {
            onImageClick()
        },
        painter = painterResource(id = imageRes),
        contentDescription = stringResource(
            id = R.string.app_logo
        )
    )
}

@Composable
@Preview
fun JetKiteLogoPreview() {
    JetKiteLogo()
}
