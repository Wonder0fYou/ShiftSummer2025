package ru.shiftsummer2025.di.featuremodules.auto

import dagger.Module
import dagger.Provides
import ru.shift.auto_data.di.AutoDependencies
import ru.shift.remote.api.BaseNetworkApi

@Module(
    includes = [AutoFeatureModule.Binder::class]
)
class AutoFeatureModule {

    @Provides
    fun provideAutoDependencies(
        baseNetworkApi: BaseNetworkApi,
    ): AutoDependencies = object : AutoDependencies {
        override val baseNetworkApi: BaseNetworkApi
            get() = baseNetworkApi
    }

    @Module
    interface Binder {
    }
}