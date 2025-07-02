package ru.shift.authorization_data.di

import ru.shift.data_store.api.BaseDataStoreApi
import ru.shift.di.BaseDependenciesApi
import ru.shift.remote.api.BaseNetworkApi

interface AuthorizationDependencies: BaseDependenciesApi {
    val baseNetworkApi: BaseNetworkApi
    val baseDataStoreApi: BaseDataStoreApi
}