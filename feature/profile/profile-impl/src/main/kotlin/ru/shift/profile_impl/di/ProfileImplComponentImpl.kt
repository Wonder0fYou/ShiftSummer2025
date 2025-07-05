package ru.shift.profile_impl.di

import dagger.Component
import ru.shift.profile_api.di.ProfileComponentApi

@Component(
    modules = [ProfileImplModule::class],
    dependencies = [ProfileImplDependencies::class],
)
interface ProfileImplComponentImpl : ProfileComponentApi{
    @Component.Factory
    interface Factory {
        fun create(
            dependencies: ProfileImplDependencies
        ): ProfileImplComponentImpl
    }
}