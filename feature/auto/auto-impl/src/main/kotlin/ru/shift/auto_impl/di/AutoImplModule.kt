package ru.shift.auto_impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.auto_impl.route.AutoRouteApiImpl
import ru.shift.auto_impl.screen.autoMain.controller.viewmodel.AutoMainScreenViewModel
import ru.shiftsummer2025.feature_api.factory.viewmodel.ViewModelFactory
import ru.shiftsummer2025.feature_api.factory.viewmodel.di.ViewModelKey
import javax.inject.Provider

@Module(
    includes = [AutoImplModule.Binder::class]
)
class AutoImplModule {

    @Provides
    fun provideViewModelFactory(
        viewModelProviders:  @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelFactory {
        return ViewModelFactory(viewModelProviders)
    }

    @Module
    interface Binder {

        @[Binds IntoMap ViewModelKey(AutoMainScreenViewModel::class)]
        fun bindAutoMainViewModel(impl: AutoMainScreenViewModel): ViewModel

        @Binds
        fun bindAutoRoute(impl: AutoRouteApiImpl): AutoRouteApi
    }
}