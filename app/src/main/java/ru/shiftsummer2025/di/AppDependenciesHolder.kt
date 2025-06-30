package ru.shiftsummer2025.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import ru.shiftsummer2025.di.route.RouteApiFactory
import javax.inject.Inject
import javax.inject.Provider

@Stable
class AppDependenciesHolder {
    @Inject
    lateinit var routeApiFactory: Provider<RouteApiFactory>
}

@Composable
fun rememberAppDependenciesHolder(appComponent: AppComponent): AppDependenciesHolder = remember {
    AppDependenciesHolder().also { appComponent.inject(it) }
}