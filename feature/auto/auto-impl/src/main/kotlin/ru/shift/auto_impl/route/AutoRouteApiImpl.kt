package ru.shift.auto_impl.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.auto_impl.screen.autoMain.controller.AutoMainScreenController
import ru.shift.auto_impl.screen.currentCar.controller.CurrentCarScreenController
import javax.inject.Inject

class AutoRouteApiImpl @Inject constructor() : AutoRouteApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation<AutoRouteApi.Screen.BASE>(
            startDestination = AutoRouteApi.Screen.AutoMain
        ) {
            composable<AutoRouteApi.Screen.AutoMain> {
                AutoMainScreenController(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable<AutoRouteApi.Screen.CurrentCar> {
                val screenArgs = it.toRoute<AutoRouteApi.Screen.CurrentCar>()
                CurrentCarScreenController(
                    modifier = modifier,
                    navController = navController,
                    screenArgs = screenArgs
                )
            }
        }
    }
}