package ru.shift.authorization_domain.userModel

data class ProfileInfo(
    val success: Boolean,
    val reason: String,
    val user: UserInfo,
    val token: String
)