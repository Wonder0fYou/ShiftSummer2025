package ru.shift.profile_impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.shift.profile_api.route.ProfileRouteApi
import ru.shift.profile_impl.route.ProfileRouteApiImpl
import ru.shiftsummer2025.feature_api.factory.viewmodel.ViewModelFactory
import javax.inject.Provider

@Module(
    includes = [ProfileImplModule.Binder::class]
)
class ProfileImplModule {

    @Provides
    fun provideViewModelFactory(
        viewModelProviders:  @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelFactory {
        return ViewModelFactory(viewModelProviders)
    }

    @Module
    interface Binder {
        @Binds
        fun bindAutoRoute(impl: ProfileRouteApiImpl): ProfileRouteApi
    }
}