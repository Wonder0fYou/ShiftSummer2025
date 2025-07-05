package ru.shift.auto_data.di

import ru.shift.di.BaseComponentHolder

object AutoDataComponentHolder : BaseComponentHolder<AutoDataComponent, AutoDependencies>() {
    override fun build(dependencies: AutoDependencies): AutoDataComponent {
        return DaggerAutoDataComponent.factory().create(dependencies)
    }
}