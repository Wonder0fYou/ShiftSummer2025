package ru.shift.authorization_api.di

import ru.shift.authorization_api.route.AuthorizationRouteApi
import ru.shift.di.BaseComponentApi
import ru.shiftsummer2025.feature_api.factory.viewmodel.ViewModelFactory

interface AuthorizationComponentApi: BaseComponentApi {
    fun viewModelFactory(): ViewModelFactory
    fun routeApi(): AuthorizationRouteApi
}