package ru.shift.profile_domain

data class UserInfo(
    val phone: String,
    val firstname: String?,
    val middleName: String?,
    val lastname: String?,
    val email: String?,
    val city: String?
)
