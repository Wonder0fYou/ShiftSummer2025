package ru.shift.auto_data.di

import dagger.Component
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.di.BaseComponentApi

@Component(
    modules = [AutoDataModule::class],
    dependencies = [AutoDependencies::class]
)
interface AutoDataComponent : BaseComponentApi {

    fun autoRepository(): AutoRepository

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: AutoDependencies
        ): AutoDataComponent
    }
}