package ru.shift.authorization_data.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.shift.authorization.api.AuthorizationRemoteApi
import ru.shift.authorization_api.repository.AuthorizationRepository
import ru.shift.authorization_data.mapper.LoginMapper
import ru.shift.authorization_domain.userModel.ProfileInfo
import ru.shift.authorization_domain.userModel.SignIn
import ru.shift.authorization_domain.userModel.UserInfo
import ru.shiftsummer2025.feature_api.result.BaseErrorApi
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val authorizationRemoteApi: AuthorizationRemoteApi,
    private val loginMapper: LoginMapper
) : AuthorizationRepository {
    override suspend fun login(signIn: SignIn): Flow<Result<ProfileInfo, BaseErrorApi>> = flow {
        val request = loginMapper.mapToSignInRequest(signIn)
        val response = authorizationRemoteApi.postSignIn(request)
        response.suspendOnSuccess(loginMapper) {
            emit(Result.Success(this))
        }.suspendOnError {

        }
    }
}