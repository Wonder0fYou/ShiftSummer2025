package ru.shiftsummer2025.di.module

import dagger.Module
import dagger.Provides
import ru.shift.remote.api.BaseNetworkApi
import ru.shift.remote.di.RemoteDataComponentHolder
import ru.shiftsummer2025.di.featuremodules.authorization.AuthorizationFeatureModule

@Module(
    includes = [
        AuthorizationFeatureModule::class
    ]
)
class FeatureModule {

    @Provides
    fun provideBaseNetworkApi(): BaseNetworkApi = RemoteDataComponentHolder.get().baseNetworkApi()
}