package ru.shift.authorization_impl.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.shift.authorization_api.route.AuthorizationRouteApi
import ru.shift.authorization_impl.screen.login.controller.AuthLoginScreenController
import javax.inject.Inject

class AuthorizationRouteApiImpl @Inject constructor(): AuthorizationRouteApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation<AuthorizationRouteApi.Screen.BASE>(
            startDestination = AuthorizationRouteApi.Screen.BASE
        ) {
            composable<AuthorizationRouteApi.Screen.Login> {
                AuthLoginScreenController(
                    modifier = modifier,
                    navController = navController
                )
            }
        }
    }
}