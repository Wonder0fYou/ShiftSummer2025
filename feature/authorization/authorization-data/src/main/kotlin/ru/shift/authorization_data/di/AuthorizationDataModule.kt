package ru.shift.authorization_data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.shift.authorization.api.AuthorizationRemoteApi
import ru.shift.authorization_api.repository.AuthorizationRepository
import ru.shift.authorization_data.repository.AuthorizationRepositoryImpl
import ru.shift.remote.api.BaseNetworkApi

@Module(
    includes = [AuthorizationDataModule.Binder::class]
)
class AuthorizationDataModule {

    @Provides
    fun provideAuthenticateApi(baseNetworkApi: BaseNetworkApi): AuthorizationRemoteApi {
        return baseNetworkApi
            .getRemoteApi(AuthorizationRemoteApi::class.java) as AuthorizationRemoteApi
    }

    @Module
    interface Binder {
        @Binds
        fun bindAuthorizationRepository(impl: AuthorizationRepositoryImpl): AuthorizationRepository
    }
}