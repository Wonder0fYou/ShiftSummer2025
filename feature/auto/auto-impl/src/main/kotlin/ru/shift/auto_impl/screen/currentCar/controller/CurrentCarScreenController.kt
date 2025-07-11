package ru.shift.auto_impl.screen.currentCar.controller

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.auto_impl.di.AutoImplComponentHolder
import ru.shift.auto_impl.screen.currentCar.controller.state.CurrentCarScreenState
import ru.shift.auto_impl.screen.currentCar.controller.viewmodel.CurrentCarScreenViewModel
import ru.shift.auto_impl.screen.currentCar.topbar.CurrentCarScreenTopBar
import ru.shift.auto_impl.screen.currentCar.ui.CurrentCarScreen
import ru.shiftsummer2025.design_system.component.ErrorState
import ru.shiftsummer2025.design_system.component.LoadingState
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold

@Composable
fun CurrentCarScreenController(
    modifier: Modifier,
    navController: NavController,
    screenArgs: AutoRouteApi.Screen.CurrentCar
) {
    val viewmodel: CurrentCarScreenViewModel = viewModel(
        factory = AutoImplComponentHolder.get().viewModelFactory()
    )

    val state = viewmodel.currentCarScreenState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewmodel.init(screenArgs.carId)
    }

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            CurrentCarScreenTopBar(
                onNavigationClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->
        when(val currentState = state.value) {
            is CurrentCarScreenState.Error -> {
                ErrorState(
                    reason = currentState.reason
                )
            }
            CurrentCarScreenState.Loading -> {
                LoadingState()
            }
            is CurrentCarScreenState.Success -> {
                CurrentCarScreen(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                    car = currentState.cars,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onOrderClick = { carId ->
                        val route = AutoRouteApi.Screen.BookingCar(carId = carId)
                        navController.navigate(route)
                    }
                )
            }
        }
    }
}