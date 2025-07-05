package ru.shift.profile_impl.screen.controller.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.shift.authorization.model.UpdateProfileDto
import ru.shift.authorization.model.request.ProfileRequest
import ru.shift.profile_api.repository.ProfileRepository
import ru.shift.profile_impl.screen.controller.state.ProfileMainScreenState
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class ProfileMainViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _profileMainScreenState =
        MutableStateFlow<ProfileMainScreenState>(ProfileMainScreenState.Loading)
    val profileMainScreenState = _profileMainScreenState.asStateFlow()

    fun loadInitialProfile() {
        viewModelScope.launch {
            val profileResult = profileRepository.getUserSession()

            profileResult.collect { result ->
                when (result) {
                    is Result.Error -> {
                        _profileMainScreenState.value = ProfileMainScreenState.Error(
                            reason = result.error.reason ?: ""
                        )
                    }

                    is Result.Success -> {
                        _profileMainScreenState.value = ProfileMainScreenState.Success(
                            userInfo = result.data
                        )
                    }
                }
            }
        }
    }

    fun updateUserProfile() {
        val currentState = _profileMainScreenState.value
        if (currentState !is ProfileMainScreenState.Success) return
        val updateProfileDto = UpdateProfileDto(
            firstname = currentState.userInfo.firstname,
            middlename = currentState.userInfo.middleName,
            lastname = currentState.userInfo.lastname,
            email = currentState.userInfo.email,
            city = currentState.userInfo.city,
        )
        viewModelScope.launch {
            val profileRequest = ProfileRequest(
                phone = currentState.userInfo.phone,
                profile = updateProfileDto
            )
            profileRepository.patchUserInfo(profileRequest).collect { result ->
                when (result) {
                    is Result.Error -> {
                        _profileMainScreenState.value = ProfileMainScreenState.Error(
                            reason = result.error.reason ?: ""
                        )
                    }

                    is Result.Success -> {
                        _profileMainScreenState.value = ProfileMainScreenState.Success(
                            userInfo = result.data
                        )
                    }
                }
            }
        }
    }

    private fun updateUserInfoState(transform: (ProfileMainScreenState.Success) -> ProfileMainScreenState.Success) {
        _profileMainScreenState.update { currentState ->
            if (currentState is ProfileMainScreenState.Success) {
                transform(currentState)
            } else {
                currentState
            }
        }
    }

    fun onFirstNameChanged(value: String) {
        updateUserInfoState { it.copy(userInfo = it.userInfo.copy(firstname = value)) }
    }

    fun onLastNameChanged(value: String) {
        updateUserInfoState { it.copy(userInfo = it.userInfo.copy(lastname = value)) }
    }

    fun onMiddleNameChanged(value: String) {
        updateUserInfoState { it.copy(userInfo = it.userInfo.copy(middleName = value)) }
    }

    fun onPhoneChanged(value: String) {
        updateUserInfoState { it.copy(userInfo = it.userInfo.copy(phone = value)) }
    }

    fun onEmailChanged(value: String) {
        updateUserInfoState { it.copy(userInfo = it.userInfo.copy(email = value)) }
    }

    fun onCityChanged(value: String) {
        updateUserInfoState { it.copy(userInfo = it.userInfo.copy(city = value)) }
    }
}