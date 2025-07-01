package ru.shiftsummer2025.di.featuremodules.authorization

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.shift.authorization_api.repository.AuthorizationRepository
import ru.shift.authorization_api.route.AuthorizationRouteApi
import ru.shift.authorization_data.di.AuthorizationDataComponentHolder
import ru.shift.authorization_impl.di.AuthorizationImplDependencies
import ru.shift.authorization_impl.route.AuthorizationRouteApiImpl
import ru.shiftsummer2025.di.route.RouteApiKey
import ru.shiftsummer2025.feature_api.route.RouteApi

@Module(
    includes = [AuthorizationFeatureModule.Binder::class]
)
class AuthorizationFeatureModule {

    @Provides
    fun provideAuthorizationImplDependencies(): AuthorizationImplDependencies =
        object : AuthorizationImplDependencies {
            override val authorizationRepository: AuthorizationRepository
                get() = AuthorizationDataComponentHolder.get().authorizationRepository()

        }

    @Module
    interface Binder {

        @IntoMap
        @RouteApiKey(value = AuthorizationRouteApi::class)
        @Binds
        fun bindAuthorizationRouteApi(impl: AuthorizationRouteApiImpl): RouteApi

    }
}