package ru.shift.authorization_impl.screen.login.controller.state

data class AuthLoginScreenState(
    val sendCodeScreen: Boolean = true,
    val isSendCodeButtonEnabled: Boolean = false,
    val isLoginButtonEnable: Boolean = false,
    val phone: String? = null,
    val code: String? = null,
)
