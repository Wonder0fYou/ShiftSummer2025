package ru.shift.auto_impl.screen.currentCar.controller.state

import ru.shift.auto_domain.CarWithRents

sealed interface CurrentCarScreenState {

    data object Loading : CurrentCarScreenState

    data class Success(
        val cars: CarWithRents
    ) : CurrentCarScreenState

    data class Error(
        val reason: String
    ) : CurrentCarScreenState
}