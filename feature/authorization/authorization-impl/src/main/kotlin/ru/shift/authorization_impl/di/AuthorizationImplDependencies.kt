package ru.shift.authorization_impl.di

import ru.shift.authorization_api.repository.AuthorizationRepository
import ru.shift.di.BaseDependenciesApi

interface AuthorizationImplDependencies : BaseDependenciesApi {
    val authorizationRepository: AuthorizationRepository
}