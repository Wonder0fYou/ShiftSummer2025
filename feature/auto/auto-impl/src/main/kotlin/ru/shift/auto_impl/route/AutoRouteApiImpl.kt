package ru.shift.auto_impl.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.auto_impl.screen.autoMain.controller.AutoMainScreenController
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
        }
    }
}