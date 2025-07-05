package ru.shift.authorization_impl.screen.login.controller

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.authorization_impl.di.AuthorizationImplComponentHolder
import ru.shift.authorization_impl.screen.login.controller.viewmodel.AuthLoginScreenViewModel
import ru.shift.authorization_impl.screen.login.topbar.AuthLoginScreenTopBar
import ru.shift.authorization_impl.screen.login.ui.AuthLoginScreen
import ru.shift.authorization_impl.screen.login.ui.SendCodeScreen
import ru.shift.auto_api.route.AutoRouteApi
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold

@Composable
fun AuthLoginScreenController(
    modifier: Modifier,
    navController: NavController,
) {
    val viewModel: AuthLoginScreenViewModel = viewModel(
        factory = AuthorizationImplComponentHolder.get().viewModelFactory()
    )

    val state = viewModel.authLoginScreenState.collectAsStateWithLifecycle()

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            AuthLoginScreenTopBar(
                onNavigationClick = { }
            )
        }
    ) { paddingValues ->
        if (state.value.sendCodeScreen) {
            SendCodeScreen(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                onSendCodeClick = {
                    viewModel.sendOtpCode()
                },
                isSendCodeButtonEnabled = state.value.isSendCodeButtonEnabled,
                onEditPhoneInput = {
                    viewModel.onPhoneChanged(it)
                },
                phone = state.value.phone ?: ""
            )
        } else {
            AuthLoginScreen(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                onLoginClick = {
                    viewModel.login {
                        navController.navigate(AutoRouteApi.Screen.BASE)
                    }
                },
                isLoginButtonEnable = state.value.isLoginButtonEnable,
                onEditCodeInput = {
                    viewModel.onOtpCodeChanged(it)
                },
                phone = state.value.phone ?: "",
                code = state.value.code ?: "",
                onEditPhoneInput = {
                    viewModel.onPhoneChanged(it)
                }
            )
        }
    }
}