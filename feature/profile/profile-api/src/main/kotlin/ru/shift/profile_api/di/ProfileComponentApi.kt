package ru.shift.profile_api.di

import ru.shift.di.BaseComponentApi
import ru.shift.profile_api.route.ProfileRouteApi
import ru.shiftsummer2025.feature_api.factory.viewmodel.ViewModelFactory

interface ProfileComponentApi : BaseComponentApi {
    fun viewModelFactory(): ViewModelFactory
    fun routeApi(): ProfileRouteApi
}