package ru.shift.authorization_impl.di

import dagger.Component
import ru.shift.authorization_api.di.AuthorizationComponentApi

@Component(
    modules = [AuthorizationImplModule::class],
    dependencies = [AuthorizationImplDependencies::class]
)
interface AuthorizationImplComponentImpl : AuthorizationComponentApi {
    @Component.Factory
    interface Factory {
        fun create(
            dependencies: AuthorizationImplDependencies
        ): AuthorizationImplComponentImpl
    }
}