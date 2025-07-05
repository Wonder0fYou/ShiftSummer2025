package ru.shift.profile_impl.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.shift.profile_api.route.ProfileRouteApi
import ru.shift.profile_impl.screen.controller.ProfileMainScreenController
import javax.inject.Inject

class ProfileRouteApiImpl @Inject constructor() : ProfileRouteApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation<ProfileRouteApi.Screen.BASE>(
            startDestination = ProfileRouteApi.Screen.ProfileMain,
        ) {
            composable<ProfileRouteApi.Screen.ProfileMain> {
                ProfileMainScreenController(
                    modifier = modifier,
                    navController = navController
                )
            }
        }
    }
}