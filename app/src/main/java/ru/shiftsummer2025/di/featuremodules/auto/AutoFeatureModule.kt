package ru.shiftsummer2025.di.featuremodules.auto

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.auto_data.di.AutoDataComponentHolder
import ru.shift.auto_data.di.AutoDependencies
import ru.shift.auto_impl.di.AutoImplDependencies
import ru.shift.auto_impl.route.AutoRouteApiImpl
import ru.shift.remote.api.BaseNetworkApi
import ru.shiftsummer2025.di.route.RouteApiKey
import ru.shiftsummer2025.feature_api.route.RouteApi

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

    @Provides
    fun provideAutoImplDependencies() : AutoImplDependencies =
        object : AutoImplDependencies {
            override val autoRepository: AutoRepository
                get() = AutoDataComponentHolder.get().autoRepository()
        }

    @Module
    interface Binder {

        @IntoMap
        @RouteApiKey(value = AutoRouteApi::class)
        @Binds
        fun bindAutoRouteApi(impl: AutoRouteApiImpl): RouteApi
    }
}