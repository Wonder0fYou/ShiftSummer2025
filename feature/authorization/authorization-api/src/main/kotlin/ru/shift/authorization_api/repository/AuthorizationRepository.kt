package ru.shift.authorization_api.repository

import kotlinx.coroutines.flow.Flow
import ru.shift.authorization_domain.AuthLoginResult
import ru.shift.authorization_domain.userModel.SignIn

interface AuthorizationRepository {
    suspend fun login(signIn: SignIn): Flow<AuthLoginResult>
}