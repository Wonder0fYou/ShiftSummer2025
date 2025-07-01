package ru.shift.authorization_impl.screen.login.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.authorization_impl.di.AuthorizationImplComponentHolder
import ru.shift.authorization_impl.screen.login.controller.viewmodel.AuthLoginScreenViewModel
import ru.shift.authorization_impl.screen.login.topbar.AuthLoginScreenTopBar
import ru.shift.authorization_impl.screen.login.ui.AuthLoginScreen
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold

@Composable
fun AuthLoginScreenController(
    modifier: Modifier,
    navController: NavController,
) {
    val viewModel: AuthLoginScreenViewModel = viewModel(
        factory = AuthorizationImplComponentHolder.get().viewModelFactory()
    )

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            AuthLoginScreenTopBar (
                onNavigationClick = { }
            )
        }
    ) { paddingValues ->
        AuthLoginScreen(

        )
    }
}