package ru.shiftsummer2025.di.featuremodules.auto

import ru.shift.auto_data.di.AutoDataComponentHolder
import ru.shift.auto_data.di.AutoDependencies
import ru.shift.auto_impl.di.AutoImplComponentHolder
import ru.shift.auto_impl.di.AutoImplDependencies
import javax.inject.Inject
import javax.inject.Provider

class AutoFeatureComponentInitializer @Inject constructor(
    private val autoDependencies: Provider<AutoDependencies>,
    private val autoImplDependencies: Provider<AutoImplDependencies>,
) {
    fun init() {
        AutoDataComponentHolder.init(autoDependencies)
        AutoImplComponentHolder.init(autoImplDependencies)
    }
}