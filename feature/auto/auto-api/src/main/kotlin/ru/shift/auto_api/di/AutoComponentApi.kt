package ru.shift.auto_api.di

import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.di.BaseComponentApi
import ru.shiftsummer2025.feature_api.factory.viewmodel.ViewModelFactory

interface AutoComponentApi : BaseComponentApi {
    fun viewModelFactory(): ViewModelFactory
    fun routeApi(): AutoRouteApi
}