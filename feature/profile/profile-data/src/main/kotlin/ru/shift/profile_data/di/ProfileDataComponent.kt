package ru.shift.profile_data.di

import dagger.Component
import ru.shift.di.BaseComponentApi
import ru.shift.profile_api.repository.ProfileRepository

@Component(
    modules = [ProfileDataModule::class],
    dependencies = [ProfileDependencies::class],
)
interface ProfileDataComponent : BaseComponentApi {

    fun profileRepository(): ProfileRepository

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: ProfileDependencies
        ): ProfileDataComponent
    }
}