package ru.shift.auto_impl.di

import ru.shift.di.BaseComponentHolder

object AutoImplComponentHolder : BaseComponentHolder<AutoImplComponentImpl, AutoImplDependencies>() {
    override fun build(dependencies: AutoImplDependencies): AutoImplComponentImpl {
        return DaggerAutoImplComponentImpl.factory().create(dependencies)
    }
}