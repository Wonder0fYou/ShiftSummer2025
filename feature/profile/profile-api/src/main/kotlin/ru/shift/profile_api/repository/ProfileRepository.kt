package ru.shift.profile_api.repository

import kotlinx.coroutines.flow.Flow
import ru.shift.authorization.model.request.ProfileRequest
import ru.shift.profile_domain.UserInfo
import ru.shiftsummer2025.feature_api.result.ReasonError
import ru.shiftsummer2025.feature_api.result.Result

interface ProfileRepository {
    suspend fun getUserSession(): Flow<Result<UserInfo, ReasonError>>
    suspend fun patchUserInfo(profileRequest: ProfileRequest): Flow<Result<UserInfo, ReasonError>>
}