package ru.shiftsummer2025.di.route

import dagger.MapKey
import ru.shiftsummer2025.feature_api.route.RouteApi
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class RouteApiKey(val value : KClass<out RouteApi>)