package com.pranay.jetkite.login.utils

/**
 * A generic class that holds a value for different login state to show login screen UI
 */
sealed class LoginState {
    object LoginStateNew : LoginState()
    object LoginStateAskPassword : LoginState()
    object LoginStateExistingUser : LoginState()
}
