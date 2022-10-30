package com.pranay.jetkite.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun JetKiteButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = RectangleShape,
        contentPadding = PaddingValues(
            vertical = MaterialTheme.spacing.medium,
            horizontal = MaterialTheme.spacing.extraSmall
        ),
        enabled = enabled
    ) {
        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
@LightDarkPreview
fun JetKiteButtonPreview() {
    JetKiteTheme {
        Surface {
            JetKiteButton(text = "Login") {
            }
        }
    }
}
