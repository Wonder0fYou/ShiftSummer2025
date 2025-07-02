package ru.shift.authorization_impl.di

import ru.shift.di.BaseComponentHolder

object AuthorizationImplComponentHolder :
    BaseComponentHolder<AuthorizationImplComponentImpl, AuthorizationImplDependencies>() {
    override fun build(dependencies: AuthorizationImplDependencies): AuthorizationImplComponentImpl {
        return DaggerAuthorizationImplComponentImpl.factory().create(dependencies)
    }
}