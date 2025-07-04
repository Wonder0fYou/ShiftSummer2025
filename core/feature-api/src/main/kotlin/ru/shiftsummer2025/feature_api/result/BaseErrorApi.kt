package ru.shiftsummer2025.feature_api.result

interface BaseErrorApi

data class ReasonError(
    val reason: String? = null
) : BaseErrorApi