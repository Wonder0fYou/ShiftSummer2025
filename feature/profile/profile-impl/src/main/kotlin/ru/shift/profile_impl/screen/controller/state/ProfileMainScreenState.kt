package ru.shift.profile_impl.screen.controller.state

import ru.shift.profile_domain.UserInfo

sealed interface ProfileMainScreenState {

    data object Loading : ProfileMainScreenState

    data class Success(
        val userInfo: UserInfo
    ): ProfileMainScreenState

    data class Error(
        val reason: String
    ) : ProfileMainScreenState
}