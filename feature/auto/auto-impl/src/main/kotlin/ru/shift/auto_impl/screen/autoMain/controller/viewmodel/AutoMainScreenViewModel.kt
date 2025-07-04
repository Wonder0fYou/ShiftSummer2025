package ru.shift.auto_impl.screen.autoMain.controller.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.auto_impl.screen.autoMain.controller.state.AutoMainScreenState
import javax.inject.Inject

class AutoMainScreenViewModel @Inject constructor(
    private val autoRepository: AutoRepository
) : ViewModel() {

    private val _autoMainState = MutableStateFlow(AutoMainScreenState.Loading)
    val autoMainState = _autoMainState.asStateFlow()
}