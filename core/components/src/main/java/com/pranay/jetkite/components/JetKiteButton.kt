package com.pranay.jetkite.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.color_white
import com.pranay.jetkite.designsystem.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetKiteButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    ElevatedButton(
        modifier = modifier
            .defaultMinSize(
                minWidth = TextFieldDefaults.MinWidth,
                minHeight = TextFieldDefaults.MinHeight
            ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = color_white,
            disabledContainerColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
            disabledContentColor = color_white.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(MaterialTheme.spacing.small),
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
            style = MaterialTheme.typography.titleMedium
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
