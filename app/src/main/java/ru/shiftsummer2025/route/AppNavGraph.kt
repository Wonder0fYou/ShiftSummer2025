package ru.shiftsummer2025.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.shift.authorization_api.route.AuthorizationRouteApi
import ru.shift.auto_api.route.AutoRouteApi
import ru.shiftsummer2025.di.AppComponent
import ru.shiftsummer2025.di.rememberAppDependenciesHolder
import ru.shiftsummer2025.feature_api.route.RouteApi
import ru.shiftsummer2025.feature_api.route.registerFeatureGraph
import kotlin.reflect.KClass

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    modifier: Modifier,
    appComponent: AppComponent,
) {
    val featureRouteApiFactory = rememberAppDependenciesHolder(
        appComponent = appComponent
    ).routeApiFactory.get()

    val routes: List<KClass<out RouteApi>> = buildList {
        add(AuthorizationRouteApi::class)
        add(AutoRouteApi::class)
    }

    NavHost(
        navController = navHostController,
//        startDestination = AutoRouteApi.Screen.BASE,
        startDestination = AuthorizationRouteApi.Screen.BASE
    ) {
        routes.forEach { routeKClass ->
            registerFeatureGraph(
                routeApi = featureRouteApiFactory.create(routeKClass),
                navController = navHostController,
                modifier = modifier
            )
        }
    }
}