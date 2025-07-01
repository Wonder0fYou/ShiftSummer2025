package ru.shift.authorization_impl.screen.login.controller.viewmodel

import androidx.lifecycle.ViewModel
import ru.shift.authorization_api.repository.AuthorizationRepository
import javax.inject.Inject

class AuthLoginScreenViewModel @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) : ViewModel(){
}