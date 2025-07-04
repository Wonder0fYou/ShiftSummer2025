package ru.shift.auto_data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.auto_data.repository.AutoRepositoryImpl
import ru.shift.cars.api.CarsRemoteApi
import ru.shift.remote.api.BaseNetworkApi

@Module(
    includes = [AutoDataModule.Binder::class]
)
class AutoDataModule {

    @Provides
    fun provideAuthenticateApi(baseNetworkApi: BaseNetworkApi): CarsRemoteApi {
        return baseNetworkApi
            .getRemoteApi(CarsRemoteApi::class.java) as CarsRemoteApi
    }

    @Module
    interface Binder {
        @Binds
        fun bindAutoRepository(impl: AutoRepositoryImpl): AutoRepository
    }
}