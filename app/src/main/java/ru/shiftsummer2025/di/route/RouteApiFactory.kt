package ru.shiftsummer2025.di.route

import ru.shiftsummer2025.feature_api.route.RouteApi
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class RouteApiFactory @Inject constructor(
    private val routeApiProviders: @JvmSuppressWildcards Map<Class<out RouteApi>, Provider<RouteApi>>,
) {
    fun <T : RouteApi> create(kClass: KClass<T>): T {
        return routeApiProviders[kClass.java]
            ?.get() as? T
            ?: throw IllegalArgumentException("No provider found for $kClass")
    }
}