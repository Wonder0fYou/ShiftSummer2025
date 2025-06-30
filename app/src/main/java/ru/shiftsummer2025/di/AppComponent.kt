package ru.shiftsummer2025.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.shift.di.BaseComponentApi
import ru.shiftsummer2025.ShiftApplication
import ru.shiftsummer2025.ui.MainActivity
import ru.shiftsummer2025.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent : BaseComponentApi {
    fun inject(mainActivity: MainActivity)
    fun inject(app: ShiftApplication)
    fun inject(appDependenciesHolder: AppDependenciesHolder)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}