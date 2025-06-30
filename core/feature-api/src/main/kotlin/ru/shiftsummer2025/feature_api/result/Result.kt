package ru.shiftsummer2025.feature_api.result

sealed interface Result<out D, out E: BaseErrorApi> {
    data class Success<out D, out E: BaseErrorApi>(val data: D): Result<D, E>
}