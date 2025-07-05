package ru.shift.profile_data.mapper

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mappers.ApiSuccessModelMapper
import ru.shift.authorization.model.response.SessionResponse
import ru.shift.profile_domain.UserInfo
import javax.inject.Inject

class ProfileMapper @Inject constructor(

) : ApiSuccessModelMapper<SessionResponse, UserInfo>{
    override fun map(apiSuccessResponse: ApiResponse.Success<SessionResponse>): UserInfo {
        val user = apiSuccessResponse.data.user
        val result = UserInfo(
            phone = user.phone,
            firstname = user.firstname,
            lastname = user.lastname,
            middleName = user.middleName,
            email = user.email,
            city = user.city
        )
        return result
    }
}