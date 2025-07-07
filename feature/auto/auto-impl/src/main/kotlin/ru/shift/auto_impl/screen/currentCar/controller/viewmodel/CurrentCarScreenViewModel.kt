package ru.shift.auto_impl.screen.currentCar.controller.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.auto_impl.screen.currentCar.controller.state.CurrentCarScreenState
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class CurrentCarScreenViewModel @Inject constructor(
    private val autoRepository: AutoRepository
) : ViewModel() {

    private val _currentCarScreenState =
        MutableStateFlow<CurrentCarScreenState>(CurrentCarScreenState.Loading)
    val currentCarScreenState = _currentCarScreenState.asStateFlow()

    fun init(carId: String) {
        viewModelScope.launch {
            autoRepository.getCarById(carId = carId).collect { result ->
                when (result) {
                    is Result.Error -> {
                        _currentCarScreenState.value =
                            CurrentCarScreenState.Error(reason = result.error.reason ?: "")
                    }

                    is Result.Success -> {
                        _currentCarScreenState.value =
                            CurrentCarScreenState.Success(result.data)
                    }
                }
            }
        }
    }
}