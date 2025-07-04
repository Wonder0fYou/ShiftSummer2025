package ru.shift.auto_impl.screen.autoMain.controller.state

sealed interface AutoMainScreenState {
    data object Loading : AutoMainScreenState
    data class Error(
        val reason: String
    ) : AutoMainScreenState
}