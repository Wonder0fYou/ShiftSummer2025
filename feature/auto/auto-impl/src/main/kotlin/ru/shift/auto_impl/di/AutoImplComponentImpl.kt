package ru.shift.auto_impl.di

import dagger.Component
import ru.shift.auto_api.di.AutoComponentApi

@Component(
    modules = [AutoImplModule::class],
    dependencies = [AutoImplDependencies::class],
)
interface AutoImplComponentImpl : AutoComponentApi {
    @Component.Factory
    interface Factory {
        fun create(
            dependencies: AutoImplDependencies
        ): AutoImplComponentImpl
    }
}