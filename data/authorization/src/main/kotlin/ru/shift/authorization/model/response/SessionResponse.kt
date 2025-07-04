package ru.shift.authorization.model.response

import ru.shift.authorization.model.UserInfoDto

data class SessionResponse(
    val success: Boolean,
    val reason: String?,
    val user: UserInfoDto
)
