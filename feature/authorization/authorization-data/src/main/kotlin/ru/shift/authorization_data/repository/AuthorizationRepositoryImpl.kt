package ru.shift.authorization_data.repository

import com.example.application.proto.UserTokensDao
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.shift.authorization.api.AuthorizationRemoteApi
import ru.shift.authorization_api.repository.AuthorizationRepository
import ru.shift.authorization_data.mapper.LoginMapper
import ru.shift.authorization_domain.userModel.OtpPhone
import ru.shift.authorization_domain.userModel.ProfileInfo
import ru.shift.authorization_domain.userModel.SignIn
import ru.shift.authorization_domain.userModel.UserInfo
import ru.shift.data_store.api.BaseDataStoreApi
import ru.shift.data_store.model.PreferenceKey
import ru.shift.otps.api.OtpsRemoteApi
import ru.shift.otps.model.response.OtpResponse
import ru.shiftsummer2025.feature_api.result.BaseErrorApi
import ru.shiftsummer2025.feature_api.result.ReasonError
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val authorizationRemoteApi: AuthorizationRemoteApi,
    private val loginMapper: LoginMapper,
    private val otpsRemoteApi: OtpsRemoteApi,
    private val baseDataStoreApi: BaseDataStoreApi
) : AuthorizationRepository {
    override suspend fun otpCode(otpPhone: OtpPhone): Flow<OtpResponse> = flow {
        val request = loginMapper.mapToOtpRequest(otpPhone)
        val response = otpsRemoteApi.postOtp(request)
        response.suspendOnSuccess {
            emit(this.data)
        }.suspendOnError {

        }
    }

    override suspend fun login(signIn: SignIn): Flow<Result<ProfileInfo, ReasonError>> = flow {
        val request = loginMapper.mapToSignInRequest(signIn)
        val response = authorizationRemoteApi.postSignIn(request)
        response.suspendOnSuccess {
            if (data.success) {
                val profileInfo = loginMapper.map(this)
                baseDataStoreApi.save<UserTokensDao>(PreferenceKey.UserToken) {
                    UserTokensDao.newBuilder()
                        .setToken(data.token)
                        .build()
                }
                emit(Result.Success(profileInfo))
            } else {
                val error = ReasonError(reason = data.reason)
                emit(Result.Error(error))
            }
        }.suspendOnError {
        }
    }
}