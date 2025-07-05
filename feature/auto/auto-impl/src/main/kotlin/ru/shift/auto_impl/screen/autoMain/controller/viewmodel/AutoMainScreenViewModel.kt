package ru.shift.auto_impl.screen.autoMain.controller.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.auto_impl.screen.autoMain.controller.state.AutoMainScreenState
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class AutoMainScreenViewModel @Inject constructor(
    private val autoRepository: AutoRepository
) : ViewModel() {

    private val _autoMainState = MutableStateFlow<AutoMainScreenState>(AutoMainScreenState.Loading)
    val autoMainState = _autoMainState.asStateFlow()

    fun loadCars() {
        viewModelScope.launch {

            val autoResult = autoRepository.getAllCars()

            autoResult
                .onStart {
                    Log.d("AutoMainScreenViewModel", "loadCars started")
                    _autoMainState.value = AutoMainScreenState.Loading
                }
                .collect { result ->
                when(result) {
                    is Result.Error -> {
                        _autoMainState.value = AutoMainScreenState.Error(
                            reason = result.error.reason ?: ""
                        )
                    }
                    is Result.Success -> {
                        Log.d("AutoMainScreenViewModel", "Success: ${result.data}")
                        _autoMainState.value = AutoMainScreenState.Success(
                            cars = result.data
                        )
                    }
                }
            }
        }
    }
}