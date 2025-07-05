package ru.shift.profile_domain

data class UpdateUserInfo(
    val firstname: String?,
    val middlename: String?,
    val lastname: String?,
    val email: String?,
    val city: String?
)
