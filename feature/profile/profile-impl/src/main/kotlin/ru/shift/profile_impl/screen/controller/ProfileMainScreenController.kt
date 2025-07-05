package ru.shift.profile_impl.screen.controller

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.shift.profile_impl.screen.topbar.ProfileMainScreenTopBar
import ru.shift.profile_impl.screen.ui.ProfileMainScreen
import ru.shiftsummer2025.design_system.component.scaffold.ShiftScaffold

@Composable
fun ProfileMainScreenController(
    modifier: Modifier,
    navController: NavController,
) {
    ShiftScaffold(
        modifier = modifier,
        topBar = {
            ProfileMainScreenTopBar()
        }
    ) { paddingValues ->
        ProfileMainScreen(
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
        )
    }
}