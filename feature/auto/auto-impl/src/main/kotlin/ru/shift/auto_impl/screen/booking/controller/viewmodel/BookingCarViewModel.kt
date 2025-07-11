package ru.shift.auto_impl.screen.booking.controller.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.auto_impl.screen.booking.controller.state.BookingCarScreenState
import ru.shift.auto_impl.screen.booking.controller.state.BookingData
import ru.shift.cars.model.request.RentCarRequest
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class BookingCarViewModel @Inject constructor(
    private val autoRepository: AutoRepository
) : ViewModel() {

    private val _bookingCarScreenState =
        MutableStateFlow<BookingCarScreenState>(BookingCarScreenState.StepOne.Loading)
    val bookingCarScreenState = _bookingCarScreenState.asStateFlow()

    private val _data = MutableStateFlow(BookingData())
    val bookingDataState = _data.asStateFlow()

    fun init(carId: String) {
        _data.update {
            it.copy(carId = carId)
        }
        _bookingCarScreenState.value = BookingCarScreenState.StepOne.Success
    }

    fun postRentCar() {
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            val oneWeekInMillis = 7L * 24 * 60 * 60 * 1000
            val inAWeek = now + oneWeekInMillis
            val dataForRequest = _data.value
            val rentCarRequest = RentCarRequest(
                carId = dataForRequest.carId ?: "",
                pickupLocation = dataForRequest.pickupLocation ?: "",
                returnLocation = dataForRequest.returnLocation ?: "",
                startDate = now,
                endDate = inAWeek,
                firstName = dataForRequest.firstName ?: "",
                lastName = dataForRequest.lastName ?: "",
                middleName = dataForRequest.middleName ?: "",
                birthDate = "1990-01-01",
                email = dataForRequest.email ?: "",
                phone = "79876543210",
                comment = dataForRequest.comment ?: ""
            )
            autoRepository.postRentCar(rentCarRequest)
                .collect { result ->
                    when (result) {
                        is Result.Error -> {

                        }

                        is Result.Success -> {

                        }
                    }
                }
        }
    }

    fun continueStepOne() {
        _bookingCarScreenState.value = BookingCarScreenState.StepTwo.Success
    }

    fun backStepTwo() {
        _bookingCarScreenState.value = BookingCarScreenState.StepOne.Success
    }

    fun continueStepTwo() {
        _bookingCarScreenState.value = BookingCarScreenState.StepThree.Success
    }

    fun backStepThree() {
        _bookingCarScreenState.value = BookingCarScreenState.StepTwo.Success
    }

    fun onPickupLocationChanged(location: String) {
        _data.update { it.copy(pickupLocation = location) }
    }

    fun onReturnLocationChanged(location: String) {
        _data.update { it.copy(returnLocation = location) }
    }

    fun onFirstNameChanged(name: String) {
        _data.update { it.copy(firstName = name) }
    }

    fun onLastNameChanged(name: String) {
        _data.update { it.copy(lastName = name) }
    }

    fun onMiddleNameChanged(name: String) {
        _data.update { it.copy(middleName = name) }
    }

    fun onBirthDateChanged(date: String) {
        _data.update { it.copy(birthDate = date) }
    }

    fun onEmailChanged(email: String) {
        _data.update { it.copy(email = email) }
    }

    fun onPhoneChanged(phone: String) {
        _data.update { it.copy(phone = phone) }
    }

    fun onCommentChanged(comment: String) {
        _data.update { it.copy(comment = comment) }
    }
}