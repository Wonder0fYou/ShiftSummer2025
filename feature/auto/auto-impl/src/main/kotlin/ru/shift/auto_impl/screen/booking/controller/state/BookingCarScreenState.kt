package ru.shift.auto_impl.screen.booking.controller.state

sealed interface BookingCarScreenState {

    sealed interface StepOne : BookingCarScreenState {

        data object Loading : StepOne

        data object Success : StepOne
    }

    sealed interface StepTwo : BookingCarScreenState {
        data object Success : StepTwo
    }

    sealed interface StepThree : BookingCarScreenState {
        data object Success : StepThree
    }
}