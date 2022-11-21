package com.pranay.jetkite.dashboard.ui.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.dashboard.R
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun OrderPlaceholder(
    placeholderTitle: String,
    placeholderSubTitle: String,
    placeholderIcon: Icon,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (placeholderIcon is Icon.ImageVectorIcon) {
            Image(imageVector = placeholderIcon.imageVector, contentDescription = placeholderTitle)
        } else if (placeholderIcon is Icon.DrawableResourceIcon) {
            Image(painter = painterResource(id = placeholderIcon.id), contentDescription = placeholderTitle)
        }
        JetKiteTextView(
            text = placeholderTitle,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.dp12)
        )
        JetKiteTextView(
            text = placeholderSubTitle,
            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.outline)
        )
    }
}

@LightDarkPreviews
@Composable
fun OrderPlaceholderPreview() {
    JetKiteTheme {
        OrderPlaceholder(
            placeholderTitle = stringResource(id = R.string.str_no_executed_order),
            placeholderSubTitle = stringResource(id = R.string.str_no_executed_order_subtitle),
            placeholderIcon = Icon.DrawableResourceIcon(JetKiteIcons.OrderPlaceholder)
        )
    }
}
