package ru.shift.remote.di

import dagger.Component
import ru.shift.di.BaseComponentApi
import ru.shift.remote.api.BaseNetworkApi
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RemoteModule::class],
    dependencies = [RemoteDataDependencies::class]
)
interface RemoteComponentApi : BaseComponentApi {

    fun baseNetworkApi(): BaseNetworkApi

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: RemoteDataDependencies
        ): RemoteComponentApi
    }
}