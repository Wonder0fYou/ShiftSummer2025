package ru.shift.profile_data.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.shift.authorization.api.AuthorizationRemoteApi
import ru.shift.authorization.model.request.ProfileRequest
import ru.shift.profile_api.repository.ProfileRepository
import ru.shift.profile_data.mapper.ProfileMapper
import ru.shift.profile_domain.UserInfo
import ru.shiftsummer2025.feature_api.result.ReasonError
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val authorizationRemoteApi: AuthorizationRemoteApi,
    private val profileMapper: ProfileMapper,
) : ProfileRepository {

    override suspend fun getUserSession(): Flow<Result<UserInfo, ReasonError>> = flow {
        val response = authorizationRemoteApi.getProfile()
        response.suspendOnSuccess {
            if (data.success) {
                val userData = profileMapper.map(this)
                emit(Result.Success(userData))
            } else {
                val error = ReasonError(reason = data.reason)
                emit(Result.Error(error))
            }
        }.suspendOnError {

        }
    }

    override suspend fun patchUserInfo(profileRequest: ProfileRequest): Flow<Result<UserInfo, ReasonError>> =
        flow {
            val response = authorizationRemoteApi.patchProfile(profileRequest)
            response.suspendOnSuccess {
                if (data.success) {
                    val userData = profileMapper.map(this)
                    emit(Result.Success(userData))
                } else {
                    val error = ReasonError(reason = data.reason)
                    emit(Result.Error(error))
                }
            }.suspendOnError {

            }
        }
}