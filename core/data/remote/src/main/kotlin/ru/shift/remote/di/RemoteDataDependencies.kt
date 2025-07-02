package ru.shift.remote.di

import ru.shift.di.BaseDependenciesApi
import ru.shift.remote.api.TokenProvider

interface RemoteDataDependencies : BaseDependenciesApi {
    val tokenProvider: TokenProvider
}