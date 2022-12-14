package com.pranay.jetkite.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.components.extension.clickableWithRipple
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.designsystem.JetKiteTheme

@Composable
fun TextViewWithEndIcon(
    text: String,
    iconRes: Int,
    modifier: Modifier = Modifier,
    onOptionClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.clickableWithRipple {
            onOptionClick()
        }
    ) {
        JetKiteTextView(
            text = text,
            modifier = modifier.align(
                Alignment.CenterStart
            )
        )
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            modifier = Modifier.align(
                Alignment.CenterEnd
            ),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun TextViewWithEndIconPreview() {
    JetKiteTheme() {
        TextViewWithEndIcon(text = stringResource(id = R.string.app_logo), iconRes = JetKiteIcons.Login)
    }
}
