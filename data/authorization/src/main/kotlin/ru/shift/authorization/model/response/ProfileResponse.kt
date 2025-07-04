package ru.shift.authorization.model.response

import com.google.gson.annotations.SerializedName
import ru.shift.authorization.model.UserInfoDto

data class ProfileResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("reason")
    val reason: String?,
    @SerializedName("user")
    val user: UserInfoDto,
    @SerializedName("token")
    val token: String
)
