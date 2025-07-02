package ru.shift.authorization_domain.userModel

data class SignIn(
    val phone: String,
    val code: Int
)
