package ru.shift.auto_impl.screen.autoMain.controller

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.auto_impl.di.AutoImplComponentHolder
import ru.shift.auto_impl.screen.autoMain.controller.state.AutoMainScreenState
import ru.shift.auto_impl.screen.autoMain.controller.viewmodel.AutoMainScreenViewModel
import ru.shift.auto_impl.screen.autoMain.topbar.AutoMainScreenTopBar
import ru.shift.auto_impl.screen.autoMain.ui.AutoMainScreen
import ru.shiftsummer2025.design_system.component.ErrorState
import ru.shiftsummer2025.design_system.component.LoadingState
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold

@Composable
fun AutoMainScreenController(
    modifier: Modifier,
    navController: NavController,
) {
    val viewModel: AutoMainScreenViewModel = viewModel(
        factory = AutoImplComponentHolder.get().viewModelFactory()
    )

    val state = viewModel.autoMainState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadCars()
    }

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            AutoMainScreenTopBar()
        }
    ) { paddingValues ->
        when (val currentState = state.value) {
            is AutoMainScreenState.Error -> {
                ErrorState(
                    reason = currentState.reason
                )
            }

            AutoMainScreenState.Loading -> {
                LoadingState()
            }

            is AutoMainScreenState.Success -> {
                AutoMainScreen(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                    onFiltersClick = {

                    },
                    cars = currentState.cars.data,
                    onCarClick = { car ->
                        val route = AutoRouteApi.Screen.CurrentCar(carId = car.id)
                        navController.navigate(route)
                    }
                )
            }
        }
    }
}