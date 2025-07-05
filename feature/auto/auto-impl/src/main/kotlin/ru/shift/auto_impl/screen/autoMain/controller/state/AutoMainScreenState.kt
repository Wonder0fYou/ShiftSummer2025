package ru.shift.auto_impl.screen.autoMain.controller.state

import ru.shift.auto_domain.CarsPaginated

sealed interface AutoMainScreenState {

    data object Loading : AutoMainScreenState

    data class Success(
        val cars: CarsPaginated
    ) : AutoMainScreenState

    data class Error(
        val reason: String
    ) : AutoMainScreenState
}