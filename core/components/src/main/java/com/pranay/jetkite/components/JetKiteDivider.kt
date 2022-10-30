package com.pranay.jetkite.components

import android.content.res.Configuration
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun JetKiteDivider(
    modifier: Modifier = Modifier,
    thickness: Dp,
    color: Color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
) {
    Divider(thickness = thickness, color = color, modifier = modifier)
}

@Composable
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun JetKiteDividerPreview() {
    JetKiteTheme {
        JetKiteDivider(thickness = MaterialTheme.spacing.dp1)
    }
}
