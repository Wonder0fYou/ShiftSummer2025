package ru.shiftsummer2025.di.module.data.remote

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.shift.remote.api.TokenProvider
import ru.shift.remote.di.RemoteDataDependencies
import ru.shiftsummer2025.data.remote.TokenProviderImpl

@Module(
    includes = [RemoteDataModule.Binder::class]
)
class RemoteDataModule {

    @Provides
    fun provideRemoteDataDependencies(
        tokenProvider: TokenProvider,
    ): RemoteDataDependencies = object : RemoteDataDependencies {
        override val tokenProvider: TokenProvider = tokenProvider
    }

    @Module
    interface Binder {
        @Binds
        fun bindTokeProvider(impl: TokenProviderImpl): TokenProvider
    }
}