package ru.shift.authorization_domain.userModel

data class UpdateProfileProfile(
    val firstname: String,
    val middleName: String,
    val lastname: String,
    val email: String,
    val city: String
)
