package ru.shiftsummer2025.di.module

import dagger.Module
import dagger.Provides
import ru.shift.remote.api.BaseNetworkApi
import ru.shift.remote.di.RemoteDataComponentHolder
import ru.shiftsummer2025.di.featuremodules.authorization.AuthorizationFeatureModule
import ru.shiftsummer2025.di.featuremodules.auto.AutoFeatureModule

@Module(
    includes = [
        AuthorizationFeatureModule::class,
        AutoFeatureModule::class,
    ]
)
class FeatureModule {

    @Provides
    fun provideBaseNetworkApi(): BaseNetworkApi = RemoteDataComponentHolder.get().baseNetworkApi()
}