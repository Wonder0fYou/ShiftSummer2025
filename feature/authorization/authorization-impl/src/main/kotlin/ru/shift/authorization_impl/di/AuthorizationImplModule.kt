package ru.shift.authorization_impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.shift.authorization_impl.screen.login.controller.viewmodel.AuthLoginScreenViewModel
import ru.shiftsummer2025.feature_api.factory.viewmodel.ViewModelFactory
import ru.shiftsummer2025.feature_api.factory.viewmodel.di.ViewModelKey
import javax.inject.Provider

@Module(
    includes = [AuthorizationImplModule.Binder::class]
)
class AuthorizationImplModule {
    @Provides
    fun provideViewModelFactory(
        viewModelProviders:  @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelFactory {
        return ViewModelFactory(viewModelProviders)
    }

    @Module
    interface Binder {
        @[Binds IntoMap ViewModelKey(AuthLoginScreenViewModel::class)]
        fun bindAuthLoginViewModel(impl: AuthLoginScreenViewModel): ViewModel
    }
}