package ru.shift.profile_data.di

import ru.shift.di.BaseDependenciesApi
import ru.shift.remote.api.BaseNetworkApi

interface ProfileDependencies: BaseDependenciesApi {
    val baseNetworkApi: BaseNetworkApi
}