package ru.shift.profile_api.route

import kotlinx.serialization.Serializable
import ru.shiftsummer2025.feature_api.route.RouteApi
import ru.shiftsummer2025.feature_api.route.ScreenApi

interface ProfileRouteApi: RouteApi {

    sealed interface Screen: ScreenApi {

        @Serializable
        data object BASE : Screen

        @Serializable
        data object ProfileMain : Screen
    }
}