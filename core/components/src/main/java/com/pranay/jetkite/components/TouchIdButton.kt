package com.pranay.jetkite.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun TouchIdButton(text: String, modifier: Modifier = Modifier, onTouchButtonClick: () -> Unit) {
    OutlinedButton(
        onClick = onTouchButtonClick,
        shape = RectangleShape,
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().defaultMinSize(minHeight = ButtonDefaults.MinHeight)
        ) {
            Image(
                painter = painterResource(id = R.drawable.touchid),
                contentDescription = "TouchId",
                modifier = Modifier.padding(end = MaterialTheme.spacing.medium)
            )
            JetKiteTextView(
                text = text,
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Medium)
            )
        }
    }
}

@LightDarkPreviews
@Composable
fun TouchIdButtonreview() {
    JetKiteTheme {
        TouchIdButton(text = "Login with biometric") {}
    }
}
