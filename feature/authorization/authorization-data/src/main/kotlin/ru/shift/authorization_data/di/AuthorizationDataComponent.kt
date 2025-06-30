package ru.shift.authorization_data.di

import dagger.Component
import ru.shift.authorization_api.repository.AuthorizationRepository
import ru.shift.di.BaseComponentApi

@Component(
    modules = [AuthorizationDataModule::class],
    dependencies = [AuthorizationDependencies::class]
)
interface AuthorizationDataComponent: BaseComponentApi {
    fun authorizationRepository(): AuthorizationRepository

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: AuthorizationDependencies
        ): AuthorizationDataComponent
    }
}