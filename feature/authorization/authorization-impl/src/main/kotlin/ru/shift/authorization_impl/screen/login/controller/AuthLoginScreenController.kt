package ru.shift.authorization_impl.screen.login.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.shift.authorization_impl.screen.login.topbar.AuthLoginScreenTopBar
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold

@Composable
fun AuthLoginScreenController(
    modifier: Modifier,
    navController: NavController,
) {

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            AuthLoginScreenTopBar (
                onNavigationClick = { }
            )
        }
    ) { paddingValues ->  

    }
}