package ru.shift.authorization_domain

sealed interface AuthLoginResult {
    data object Success : AuthLoginResult
}