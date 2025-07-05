package ru.shift.auto_data.di

import ru.shift.di.BaseDependenciesApi
import ru.shift.remote.api.BaseNetworkApi

interface AutoDependencies: BaseDependenciesApi {
    val baseNetworkApi: BaseNetworkApi
}