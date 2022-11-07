package com.pranay.jetkite.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.components.JetKiteBackButton
import com.pranay.jetkite.components.JetKiteButton
import com.pranay.jetkite.components.JetKiteLogo
import com.pranay.jetkite.components.JetKiteTextField
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.JetKiteTextViewPrimary
import com.pranay.jetkite.components.R
import com.pranay.jetkite.components.TouchIdButton
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.components.extension.clickableWithRipple
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing
import com.pranay.jetkite.login.utils.LoginState
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(
    loginState: LoginState = LoginState.LoginStateNew,
    onNavigationBackClick: () -> Unit = {},
    onForgotClick: () -> Unit = {},
    onSwitchAccountClick: () -> Unit = {},
    onLoginSuccess: () -> Unit
) {
    var textUserName by rememberSaveable { mutableStateOf(TextFieldValue("")) }
    var password by rememberSaveable { mutableStateOf(TextFieldValue("")) }
    var otpValue by rememberSaveable { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current
    val showPassword = rememberSaveable { mutableStateOf(false) }
    val matchError = rememberSaveable { mutableStateOf(false) }
    var seconds by rememberSaveable { mutableStateOf(60) }

    Surface {
        Column(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraLarge, Alignment.Top),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.spacing.small)
        ) {
            Box(modifier = Modifier.fillMaxWidth().padding(end = MaterialTheme.spacing.medium)) {
                JetKiteBackButton(
                    modifier = Modifier.size(
                        height = MaterialTheme.spacing.dp50,
                        width = MaterialTheme.spacing.dp50
                    ).align(Alignment.CenterStart),
                    onClick = onNavigationBackClick
                )
                JetKiteLogo(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(
                            height = MaterialTheme.spacing.smallImage,
                            width = MaterialTheme.spacing.dp50
                        )
                )
            }
            if (loginState == LoginState.LoginStateOTPCase) {
                LaunchedEffect(seconds) {
                    if (seconds >= 1) {
                        delay(1000)
                        seconds -= 1
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = JetKiteIcons.UserPlaceholder),
                        contentDescription = stringResource(com.pranay.jetkite.login.R.string.person_icon)
                    )
                    Spacer(modifier = Modifier.padding(MaterialTheme.spacing.extraSmall))
                    JetKiteTextView(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = MaterialTheme.spacing.medium),
                        text = stringResource(id = com.pranay.jetkite.login.R.string.enter_otp_info),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            MaterialTheme.colorScheme.outline.copy(
                                alpha = 0.5f
                            )
                        )
                    )
                    JetKiteTextField(
                        textValue = otpValue,
                        singleLine = true,
                        isError = matchError.value,
                        label = {
                            JetKiteTextView(text = stringResource(com.pranay.jetkite.login.R.string.enter_sms_email_otp))
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = JetKiteIcons.OtpSubmit),
                                contentDescription = stringResource(com.pranay.jetkite.login.R.string.enter_sms_email_otp),
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.clickableWithRipple {
                                    // Do with OTP send icon
                                }.rotate(90f)
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                // Do with OTP send icon
                            }
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            autoCorrect = true,
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        )
                    ) {
                        otpValue = it
                    }
                    Spacer(modifier = Modifier.padding(MaterialTheme.spacing.extraSmall))
                    JetKiteTextView(
                        modifier = if (seconds > 0) Modifier.padding(horizontal = MaterialTheme.spacing.medium) else Modifier.padding(
                            horizontal = MaterialTheme.spacing.medium
                        ).clickableWithRipple { },
                        text = if (seconds > 0) "Resend OTP in $seconds seconds" else "Reset OTP",
                        style = MaterialTheme.typography.titleSmall.copy(
                            if (seconds > 0) MaterialTheme.colorScheme.outline.copy(
                                alpha = 0.5f
                            ) else MaterialTheme.colorScheme.outline.copy(alpha = 0.9f)
                        )
                    )
                }
                return@Column
            }
            if (loginState != LoginState.LoginStateNew) {
                Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
                UserInfoView("Pranaykumar Atulbhai Patel", "PA", "AA0000")
            } else {
                Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
            }
            if (loginState == LoginState.LoginStateExistingUser) {
                Spacer(modifier = Modifier.padding(MaterialTheme.spacing.small))
                TouchIdButton(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium), text = "Login with biometric") {
                }
            }
            if (loginState == LoginState.LoginStateNew) {
                JetKiteTextView(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
                    text = stringResource(com.pranay.jetkite.login.R.string.string_login),
                    style = MaterialTheme.typography.displaySmall
                )
                JetKiteTextField(
                    textValue = textUserName,
                    singleLine = true,
                    label = {
                        JetKiteTextView(text = stringResource(com.pranay.jetkite.login.R.string.string_loginid))
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_person),
                            contentDescription = stringResource(com.pranay.jetkite.login.R.string.string_loginid),
                            tint = MaterialTheme.colorScheme.outline
                        )
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
            }
            if (loginState != LoginState.LoginStateExistingUser) {
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
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "Visibility",
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.clickableWithRipple {
                                showPassword.value = !showPassword.value
                            }
                        )
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
            }
            if (loginState != LoginState.LoginStateExistingUser) {
                JetKiteButton(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.medium),
                    text = stringResource(id = com.pranay.jetkite.login.R.string.string_login)
                ) {
                }
                Box(modifier = Modifier.fillMaxWidth().padding(horizontal = MaterialTheme.spacing.medium)) {
                    if (loginState == LoginState.LoginStateAskPassword) {
                        JetKiteTextViewPrimary(
                            text = stringResource(com.pranay.jetkite.login.R.string.switch_account),
                            modifier = Modifier
                                .align(Alignment.CenterStart),
                            onTextViewClick = onSwitchAccountClick
                        )
                    }
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
}

@Composable
fun UserInfoView(name: String, initials: String, userID: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(MaterialTheme.spacing.dp100)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), CircleShape)
        ) {
            JetKiteTextView(
                text = initials,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                    textAlign = TextAlign.Center
                ),
                maxLines = 1
            )
        }
        JetKiteTextView(
            text = name,
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.small),
            style = MaterialTheme.typography.titleLarge
        )
        JetKiteTextView(
            text = userID,
            style = MaterialTheme.typography.titleSmall.copy(MaterialTheme.colorScheme.outline.copy(alpha = 0.5f))
        )
    }
}

@LightDarkPreview
@Composable
fun LoginScreenPreview() {
    JetKiteTheme {
        LoginScreen() {}
    }
}

@Preview
@Composable
fun LoginScreenPreviewPassword() {
    JetKiteTheme {
        LoginScreen(loginState = LoginState.LoginStateAskPassword) {}
    }
}

@Preview
@Composable
fun LoginScreenPreviewFinger() {
    JetKiteTheme {
        LoginScreen(loginState = LoginState.LoginStateExistingUser) {}
    }
}

@Preview
@Composable
fun LoginScreenPreviewOTP() {
    JetKiteTheme {
        LoginScreen(loginState = LoginState.LoginStateOTPCase) {}
    }
}

@LightDarkPreview
@Composable
fun UserInfoViewPreview() {
    JetKiteTheme {
        UserInfoView("Pranay", "PA", "AA0000")
    }
}
