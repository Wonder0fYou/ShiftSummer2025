package ru.shift.auto_impl.screen.booking.controller

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.auto_api.route.AutoRouteApi
import ru.shift.auto_impl.di.AutoImplComponentHolder
import ru.shift.auto_impl.screen.booking.controller.state.BookingCarScreenState
import ru.shift.auto_impl.screen.booking.controller.viewmodel.BookingCarViewModel
import ru.shift.auto_impl.screen.booking.topbar.StepOneScreenTopBar
import ru.shift.auto_impl.screen.booking.topbar.StepThreeScreenTopBar
import ru.shift.auto_impl.screen.booking.topbar.StepTwoScreenTopBar
import ru.shift.auto_impl.screen.booking.ui.StepOneScreen
import ru.shift.auto_impl.screen.booking.ui.StepThreeScreen
import ru.shift.auto_impl.screen.booking.ui.StepTwoScreen
import ru.shiftsummer2025.design_system.component.LoadingState
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold

@Composable
fun BookingCarScreenController(
    modifier: Modifier,
    navController: NavController,
    screenArgs: AutoRouteApi.Screen.BookingCar
) {
    val viewmodel: BookingCarViewModel = viewModel(
        factory = AutoImplComponentHolder.get().viewModelFactory()
    )

    val state = viewmodel.bookingCarScreenState.collectAsStateWithLifecycle().value
    val bookingData by viewmodel.bookingDataState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewmodel.init(screenArgs.carId)
    }

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            when (state) {
                is BookingCarScreenState.StepOne -> StepOneScreenTopBar(onNavigationClick = { navController.popBackStack() })
                is BookingCarScreenState.StepTwo -> StepTwoScreenTopBar(onNavigationClick = { viewmodel.backStepTwo() })
                is BookingCarScreenState.StepThree -> StepThreeScreenTopBar(onNavigationClick = { viewmodel.backStepThree() })
            }
        }
    ) { paddingValues ->
        when (state) {
            is BookingCarScreenState.StepOne -> {
                when (state) {
                    BookingCarScreenState.StepOne.Loading -> LoadingState()
                    is BookingCarScreenState.StepOne.Success -> {
                        StepOneScreen(
                            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                            bookingData = bookingData,
                            onPickupLocationChanged = viewmodel::onPickupLocationChanged,
                            onReturnLocationChanged = viewmodel::onReturnLocationChanged,
                            onContinueClick = viewmodel::continueStepOne
                        )
                    }
                }
            }

            is BookingCarScreenState.StepTwo -> {
                when (state) {
                    is BookingCarScreenState.StepTwo.Success -> {
                        StepTwoScreen(
                            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                            bookingData = bookingData,
                            onFirstNameChanged = viewmodel::onFirstNameChanged,
                            onLastNameChanged = viewmodel::onLastNameChanged,
                            onMiddleNameChanged = viewmodel::onMiddleNameChanged,
                            onBirthDateChanged = viewmodel::onBirthDateChanged,
                            onPhoneChanged = viewmodel::onPhoneChanged,
                            onEmailChanged = viewmodel::onEmailChanged,
                            onCommentChanged = viewmodel::onCommentChanged,
                            onContinueClick = viewmodel::continueStepTwo
                        )
                    }
                }
            }

            is BookingCarScreenState.StepThree -> {
                when (state) {
                    is BookingCarScreenState.StepThree.Success -> {
                        StepThreeScreen(
                            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                            onOrderClick = {
                                viewmodel.postRentCar()
                                navController.navigate(AutoRouteApi.Screen.AutoMain)
                            }
                        )
                    }
                }
            }
        }
    }
}