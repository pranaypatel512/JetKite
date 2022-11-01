package com.pranay.jetkite.components

import android.content.res.Configuration
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.components.extension.clickableWithRipple
import com.pranay.jetkite.designsystem.JetKiteTheme

@Composable
fun JetKiteTextView(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current
) {
    Text(text = text, style = style, modifier = modifier)
}

@Composable
fun JetKiteTextViewPrimary(
    modifier: Modifier = Modifier,
    text: String,
    onTextViewClick: () -> Unit = {}
) {
    JetKiteTextView(
        text = text,
        modifier = modifier.clickableWithRipple {
            onTextViewClick()
        },
        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary)
    )
}

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun JetKiteTextViewPreview() {
    JetKiteTheme {
        Surface {
            JetKiteTextView(text = stringResource(id = R.string.app_logo))
        }
    }
}
