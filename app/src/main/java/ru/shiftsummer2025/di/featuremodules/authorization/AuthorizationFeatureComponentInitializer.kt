package ru.shiftsummer2025.di.featuremodules.authorization

import ru.shift.authorization_impl.di.AuthorizationImplComponentHolder
import ru.shift.authorization_impl.di.AuthorizationImplDependencies
import javax.inject.Inject
import javax.inject.Provider

class AuthorizationFeatureComponentInitializer @Inject constructor(
    private val authorizationImplDependencies: Provider<AuthorizationImplDependencies>
) {
    fun init() {
        AuthorizationImplComponentHolder.init(authorizationImplDependencies)
    }
}