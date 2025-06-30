package ru.shiftsummer2025

import android.app.Application
import ru.shiftsummer2025.di.AppComponent
import ru.shiftsummer2025.di.ComponentHolderInitializer
import javax.inject.Inject

class ShiftApplication: Application() {
    @Inject
    lateinit var componentHolderInitializer: ComponentHolderInitializer

    val component: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        componentHolderInitializer.init()
    }
}