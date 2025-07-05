package ru.shift.profile_impl.screen.controller

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.authorization_api.route.AuthorizationRouteApi
import ru.shift.profile_impl.di.ProfileImplComponentHolder
import ru.shift.profile_impl.screen.controller.state.ProfileMainScreenState
import ru.shift.profile_impl.screen.controller.viewmodel.ProfileMainViewModel
import ru.shift.profile_impl.screen.topbar.ProfileMainScreenTopBar
import ru.shift.profile_impl.screen.ui.ProfileMainScreen
import ru.shiftsummer2025.design_system.component.bottomSheet.ShiftBottomSheet
import ru.shiftsummer2025.design_system.component.button.UiButton
import ru.shiftsummer2025.design_system.component.button.UiButtonStyle
import ru.shiftsummer2025.design_system.component.circularProgressIndicator.ShiftCircularProgressIndicator
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileMainScreenController(
    modifier: Modifier,
    navController: NavController,
) {

    val viewModel: ProfileMainViewModel = viewModel(
        factory = ProfileImplComponentHolder.get().viewModelFactory()
    )

    LaunchedEffect(Unit) {
        viewModel.loadInitialProfile()
    }

    val state = viewModel.profileMainScreenState.collectAsStateWithLifecycle()

    var showLogoutBottomSheet by remember { mutableStateOf(false) }

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            ProfileMainScreenTopBar()
        }
    ) { paddingValues ->
        when (val currentState = state.value) {
            is ProfileMainScreenState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ShiftText(
                        text = currentState.reason,
                        textStyle = TextStyle.TITLE_H2,
                    )
                }
            }

            ProfileMainScreenState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ShiftCircularProgressIndicator(
                        modifier = Modifier.size(48.dp)
                    )
                }
            }

            is ProfileMainScreenState.Success -> {
                val userInfo = currentState.userInfo
                ProfileMainScreen(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                    firstName = userInfo.firstname ?: "",
                    lastName = userInfo.lastname ?: "",
                    middleName = userInfo.middleName ?: "",
                    phone = userInfo.phone,
                    email = userInfo.email ?: "",
                    city = userInfo.city ?: "",
                    onFirstNameEdit = viewModel::onFirstNameChanged,
                    onLastNameEdit = viewModel::onLastNameChanged,
                    onMiddleNameEdit = viewModel::onMiddleNameChanged,
                    onPhoneEdit = viewModel::onPhoneChanged,
                    onEmailEdit = viewModel::onEmailChanged,
                    onCityEdit = viewModel::onCityChanged,
                    onUpdateUserInfoClick = viewModel::updateUserProfile,
                    onLogoutClick = {
                        showLogoutBottomSheet = true
                    },
                )
            }
        }
    }
    if (showLogoutBottomSheet) {
        ShiftBottomSheet(
            onDismissRequest = { showLogoutBottomSheet = false }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ShiftText(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "Вы точно хотите выйти?",
                    textStyle = TextStyle.TITLE_H2
                )
                UiButton(
                    modifier = Modifier
                        .padding(
                            bottom = 8.dp,
                            top = 16.dp,
                        ),
                    textInButton = "Отменить",
                    style = UiButtonStyle.EMPTY,
                    onClick = {
                        showLogoutBottomSheet = false
                    }
                )
                UiButton(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    textInButton = "Выйти",
                    style = UiButtonStyle.PRIMARY,
                    onClick = {
                        showLogoutBottomSheet = false
                        navController.navigate(AuthorizationRouteApi.Screen.BASE) {
                            popUpTo(0) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}