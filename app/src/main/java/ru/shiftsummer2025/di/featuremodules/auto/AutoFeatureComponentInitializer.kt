package ru.shiftsummer2025.di.featuremodules.auto

import ru.shift.auto_data.di.AutoDataComponentHolder
import ru.shift.auto_data.di.AutoDependencies
import javax.inject.Inject
import javax.inject.Provider

class AutoFeatureComponentInitializer @Inject constructor(
    private val autoDependencies: Provider<AutoDependencies>
) {
    fun init() {
        AutoDataComponentHolder.init(autoDependencies)
    }
}