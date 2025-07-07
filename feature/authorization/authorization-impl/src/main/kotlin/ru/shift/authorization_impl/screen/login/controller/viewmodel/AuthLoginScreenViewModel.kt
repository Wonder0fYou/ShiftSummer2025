package ru.shift.authorization_impl.screen.login.controller.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.shift.authorization_api.repository.AuthorizationRepository
import ru.shift.authorization_domain.userModel.OtpPhone
import ru.shift.authorization_domain.userModel.SignIn
import ru.shift.authorization_impl.screen.login.controller.state.AuthLoginScreenState
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class AuthLoginScreenViewModel @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) : ViewModel() {

    private val _authLoginScreenState = MutableStateFlow(AuthLoginScreenState())
    val authLoginScreenState = _authLoginScreenState.asStateFlow()

    fun sendOtpCode() {
        viewModelScope.launch {
            val state = _authLoginScreenState.value
            val otpPhone = OtpPhone(
                phone = state.phone ?: ""
            )
            val authResult = authorizationRepository.otpCode(otpPhone)

            authResult.collect {
                _authLoginScreenState.update {
                    it.copy(sendCodeScreen = false)
                }
            }
        }
    }

    fun login(onLogin: () -> Unit) {
        viewModelScope.launch {
            val state = _authLoginScreenState.value
            val signIn = SignIn(
                phone = state.phone ?: "",
                code = state.code?.toInt() ?: 0
            )
            val authResult = authorizationRepository.login(
                signIn = signIn
            )

            authResult.collect { result ->
                when (result) {
                    is Result.Success -> {
                        onLogin()
                    }

                    is Result.Error -> {
                        TODO()
                    }
                }
            }
        }
    }

    fun onPhoneChanged(phone: String) {
        _authLoginScreenState.value =
            _authLoginScreenState.value.copy(phone = phone, isSendCodeButtonEnabled = true)
    }

    fun onOtpCodeChanged(code: String) {
        _authLoginScreenState.value =
            _authLoginScreenState.value.copy(
                code = code,
                isLoginButtonEnable = true
            )
    }
}