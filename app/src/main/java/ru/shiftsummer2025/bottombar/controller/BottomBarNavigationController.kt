package ru.shiftsummer2025.bottombar.controller

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.shiftsummer2025.bottombar.model.BottomBarNavigationItem
import ru.shiftsummer2025.design_system.bottombar.BottomBarNavigationItem
import ru.shiftsummer2025.design_system.bottombar.ShiftNavigationBar
import ru.shiftsummer2025.feature_api.route.ScreenApi

@Composable
fun BottomBarNavigationController(
    navController: NavController,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentParentRoute = backStackEntry?.destination?.parent?.route
    val isNavigationBarVisibleOnCurrentRoute = backStackEntry?.destination
        ?.arguments?.containsKey("hideBottomNavigationBar") == false

    val tabs = remember { BottomBarNavigationItem.values() }
    val tabRoutes = remember { tabs.map { it.route.toClassName } }

    if (currentParentRoute in tabRoutes && isNavigationBarVisibleOnCurrentRoute) {
        ShiftNavigationBar(
            modifier = Modifier
                .padding(top = 4.dp)
                .clip(
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
        ) {
            NavigationBarItems(tabs, currentParentRoute, navController)
        }
    }
}

@Composable
private fun RowScope.NavigationBarItems(
    tabs: List<BottomBarNavigationItem>,
    currentRoute: String?,
    navController: NavController
) {
    tabs.forEach { tab ->
        val tabRoute = tab.route.toClassName
        BottomBarNavigationItem(
            isSelected = currentRoute == tabRoute,
            label = tab.label,
            iconRes = tab.iconRes,
        ) {
            if (currentRoute != tabRoute) {
                navController.navigate(tab.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
}

private val ScreenApi.toClassName: String?
    get() = this::class.qualifiedName