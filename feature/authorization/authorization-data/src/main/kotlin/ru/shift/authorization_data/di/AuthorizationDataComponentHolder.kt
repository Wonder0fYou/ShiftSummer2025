package ru.shift.authorization_data.di

import ru.shift.di.BaseComponentHolder

object AuthorizationDataComponentHolder :
    BaseComponentHolder<AuthorizationDataComponent, AuthorizationDependencies>() {
    override fun build(dependencies: AuthorizationDependencies): AuthorizationDataComponent {
        return DaggerAuthorizationDataComponent.factory().create(dependencies)
    }
}