package ru.shift.profile_data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.shift.authorization.api.AuthorizationRemoteApi
import ru.shift.profile_api.repository.ProfileRepository
import ru.shift.profile_data.repository.ProfileRepositoryImpl
import ru.shift.remote.api.BaseNetworkApi

@Module(
    includes = [ProfileDataModule.Binder::class]
)
class ProfileDataModule {

    @Provides
    fun provideAuthenticateApi(baseNetworkApi: BaseNetworkApi): AuthorizationRemoteApi {
        return baseNetworkApi
            .getRemoteApi(AuthorizationRemoteApi::class.java) as AuthorizationRemoteApi
    }

    @Module
    interface Binder {
        @Binds
        fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository
    }
}