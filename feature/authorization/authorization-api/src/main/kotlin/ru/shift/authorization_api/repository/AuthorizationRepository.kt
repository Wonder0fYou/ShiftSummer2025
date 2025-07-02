package ru.shift.authorization_api.repository

import kotlinx.coroutines.flow.Flow
import ru.shift.authorization_domain.userModel.OtpPhone
import ru.shift.authorization_domain.userModel.ProfileInfo
import ru.shift.authorization_domain.userModel.SignIn
import ru.shift.authorization_domain.userModel.UserInfo
import ru.shift.otps.model.response.OtpResponse
import ru.shiftsummer2025.feature_api.result.BaseErrorApi
import ru.shiftsummer2025.feature_api.result.Result

interface AuthorizationRepository {
    suspend fun otpCode(otpPhone: OtpPhone): Flow<OtpResponse>
    suspend fun login(signIn: SignIn): Flow<Result<ProfileInfo, BaseErrorApi>>
}