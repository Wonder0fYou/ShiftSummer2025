package ru.shiftsummer2025.feature_api.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.registerFeatureGraph(
    routeApi: RouteApi,
    navController: NavController,
    modifier: Modifier,
) {
    routeApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}