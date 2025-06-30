package ru.shift.di

import javax.inject.Provider

abstract class BaseComponentHolder<COMPONENT: BaseComponentApi, DEPENDENCIES: BaseDependenciesApi> {

    private var component: COMPONENT? = null

    private lateinit var dependenciesProvider: Provider<DEPENDENCIES>

    protected abstract fun build(dependencies: DEPENDENCIES): COMPONENT

    fun get(): COMPONENT = component ?: build(dependenciesProvider.get())
        .also { newComponent -> component = newComponent }

    fun init(dependencies: Provider<DEPENDENCIES>) {
        if(::dependenciesProvider.isInitialized) {
            throw IllegalStateException("Dependencies must be initialized only one time")
        }

        dependenciesProvider = dependencies
    }

    fun clear() {
        component = null
    }
}