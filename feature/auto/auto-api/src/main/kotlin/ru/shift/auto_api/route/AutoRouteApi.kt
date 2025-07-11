package ru.shift.auto_api.route

import kotlinx.serialization.Serializable
import ru.shiftsummer2025.feature_api.route.RouteApi
import ru.shiftsummer2025.feature_api.route.ScreenApi

interface AutoRouteApi : RouteApi {

    sealed interface Screen : ScreenApi {

        @Serializable
        data object BASE : Screen

        @Serializable
        data object AutoMain : Screen

        @Serializable
        data class CurrentCar(
            val carId: String
        ): Screen

        @Serializable
        data class BookingCar(
            val carId: String
        ): Screen
    }
}