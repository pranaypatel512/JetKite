package com.pranay.jetkite.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.pranay.jetkite.components.JetKiteBackButton
import com.pranay.jetkite.components.JetKiteButton
import com.pranay.jetkite.components.JetKiteLogo
import com.pranay.jetkite.components.JetKiteTextField
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.JetKiteTextViewPrimary
import com.pranay.jetkite.components.R
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.components.extension.SystemBarsPaddingSpacer
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun LoginScreen(
    onNavigationBackClick: () -> Unit = {},
    onForgotClick: () -> Unit = {},
    onSwitchAccountClick: () -> Unit = {},
    onLoginSuccess: () -> Unit
) {
    var textUserName by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current
    val showPassword = remember { mutableStateOf(false) }
    val matchError = remember { mutableStateOf(false) }

    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraLarge, Alignment.Top),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.spacing.small)
        ) {
            SystemBarsPaddingSpacer()
            Box(modifier = Modifier.fillMaxWidth().padding(end = MaterialTheme.spacing.medium)) {
                JetKiteBackButton(
                    modifier = Modifier.size(
                        height = MaterialTheme.spacing.mediumImage,
                        width = MaterialTheme.spacing.mediumImage
                    ).align(Alignment.CenterStart),
                    onClick = onNavigationBackClick
                )
                JetKiteLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(
                            height = MaterialTheme.spacing.mediumImage,
                            width = MaterialTheme.spacing.mediumImage
                        )
                )
            }
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
            JetKiteTextView(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium), text = stringResource(com.pranay.jetkite.login.R.string.string_login), style = MaterialTheme.typography.displaySmall)
//            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.large))
            JetKiteTextField(
                textValue = textUserName,
                singleLine = true,
                label = {
                    JetKiteTextView(text = stringResource(com.pranay.jetkite.login.R.string.string_loginid))
                },
                trailingIcon = {
                    IconButton(onClick = { showPassword.value = !showPassword.value }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_person),
                            contentDescription = stringResource(com.pranay.jetkite.login.R.string.string_loginid),
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                },
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            ) {
                textUserName = it
            }
//            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.large))
            JetKiteTextField(
                textValue = password,
                singleLine = true,
                isError = matchError.value,
                label = {
                    JetKiteTextView(text = stringResource(com.pranay.jetkite.login.R.string.string_password))
                },
                trailingIcon = {
                    val icon = if (showPassword.value) {
                        JetKiteIcons.Visibility
                    } else {
                        JetKiteIcons.VisibilityOff
                    }
                    IconButton(onClick = { showPassword.value = !showPassword.value }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "Visibility",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                },
                visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            ) {
                password = it
            }
            JetKiteButton(modifier = Modifier.fillMaxWidth().padding(horizontal = MaterialTheme.spacing.medium), text = stringResource(id = com.pranay.jetkite.login.R.string.string_login)) {
            }
            Box(modifier = Modifier.fillMaxWidth().padding(end = MaterialTheme.spacing.medium)) {
                JetKiteTextViewPrimary(
                    text = stringResource(com.pranay.jetkite.login.R.string.switch_account),
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    onTextViewClick = onSwitchAccountClick
                )
                JetKiteTextViewPrimary(
                    text = stringResource(com.pranay.jetkite.login.R.string.forgot_your_password_or_userid),
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    onTextViewClick = onForgotClick
                )
            }
        }
    }
}

@LightDarkPreview
@Composable
fun LoginScreenPreview() {
    JetKiteTheme {
        LoginScreen() {}
    }
}
