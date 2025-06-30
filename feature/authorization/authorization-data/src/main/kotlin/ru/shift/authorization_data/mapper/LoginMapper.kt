package ru.shift.authorization_data.mapper

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mappers.ApiSuccessModelMapper
import ru.shift.authorization.model.UserInfoDto
import ru.shift.authorization.model.request.SignInRequest
import ru.shift.authorization.model.response.ProfileResponse
import ru.shift.authorization_domain.userModel.ProfileInfo
import ru.shift.authorization_domain.userModel.SignIn
import ru.shift.authorization_domain.userModel.UserInfo
import javax.inject.Inject

class LoginMapper @Inject constructor(

) : ApiSuccessModelMapper<ProfileResponse, ProfileInfo> {
    override fun map(apiSuccessResponse: ApiResponse.Success<ProfileResponse>): ProfileInfo {
        val data = apiSuccessResponse.data
        val result = ProfileInfo(
            success = data.success,
            reason = data.reason,
            user = mapToUserInfo(data.user),
            token = data.token
        )
        return result
    }

    fun mapToSignInRequest(signIn: SignIn): SignInRequest = SignInRequest(
        signIn.phone,
        signIn.code
    )

    private fun mapToUserInfo(userInfoDto: UserInfoDto): UserInfo = UserInfo(
        phone = userInfoDto.phone,
        firstname = userInfoDto.firstname,
        middleName = userInfoDto.middleName,
        lastname = userInfoDto.lastname,
        email = userInfoDto.email,
        city = userInfoDto.city
    )
}