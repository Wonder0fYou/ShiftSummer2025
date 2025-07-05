package ru.shiftsummer2025.bottombar.model

import androidx.annotation.DrawableRes
import ru.shift.auto_api.route.AutoRouteApi
import ru.shiftsummer2025.design_system.R
import ru.shiftsummer2025.feature_api.route.ScreenApi

sealed class BottomBarNavigationItem(
    open val label: String,
    open val route: ScreenApi,
    @DrawableRes open val iconRes: Int,
) {
    data class Auto(
        override val label: String = "Авто",
        override val route: ScreenApi = AutoRouteApi.Screen.BASE,
        override val iconRes: Int = R.drawable.ic_auto
    ) : BottomBarNavigationItem(
        label = label,
        route = route,
        iconRes = iconRes
    )

    data class Orders(
        override val label: String = "Заказы",
        override val route: ScreenApi,
        override val iconRes: Int = R.drawable.ic_orders
    ) : BottomBarNavigationItem(
        label = label,
        route = route,
        iconRes = iconRes
    )

    data class Profile(
        override val label: String = "Профиль",
        override val route: ScreenApi,
        override val iconRes: Int = R.drawable.ic_profile
    ) : BottomBarNavigationItem(
        label = label,
        route = route,
        iconRes = iconRes
    )

    companion object {
        fun values(): List<BottomBarNavigationItem> {
            return listOf(
                Auto(),
//                Orders(),
//                Profile(),
            )
        }
    }
}