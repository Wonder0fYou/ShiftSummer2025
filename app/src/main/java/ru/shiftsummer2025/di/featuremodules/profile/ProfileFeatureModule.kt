package ru.shiftsummer2025.di.featuremodules.profile

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.shift.profile_api.repository.ProfileRepository
import ru.shift.profile_api.route.ProfileRouteApi
import ru.shift.profile_data.di.ProfileDataComponentHolder
import ru.shift.profile_data.di.ProfileDependencies
import ru.shift.profile_impl.di.ProfileImplDependencies
import ru.shift.profile_impl.route.ProfileRouteApiImpl
import ru.shift.remote.api.BaseNetworkApi
import ru.shiftsummer2025.di.route.RouteApiKey

@Module(
    includes = [ProfileFeatureModule.Binder::class]
)
class ProfileFeatureModule {

    @Provides
    fun provideProfileDependencies(
        baseNetworkApi: BaseNetworkApi,
    ): ProfileDependencies = object : ProfileDependencies {
        override val baseNetworkApi: BaseNetworkApi
            get() = baseNetworkApi
    }

    @Provides
    fun provideProfileImplDependencies(): ProfileImplDependencies =
        object : ProfileImplDependencies {
            override val profileRepository: ProfileRepository
                get() = ProfileDataComponentHolder.get().profileRepository()
        }

    @Module
    interface Binder {
        @IntoMap
        @RouteApiKey(value = ProfileRouteApi::class)
        @Binds
        fun bindProfileRouteApi(impl: ProfileRouteApiImpl): ProfileRouteApi
    }
}