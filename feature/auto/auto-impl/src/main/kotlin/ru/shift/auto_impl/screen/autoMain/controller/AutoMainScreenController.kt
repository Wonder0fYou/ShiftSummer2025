package ru.shift.auto_impl.screen.autoMain.controller

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.auto_impl.di.AutoImplComponentHolder
import ru.shift.auto_impl.screen.autoMain.controller.state.AutoMainScreenState
import ru.shift.auto_impl.screen.autoMain.controller.viewmodel.AutoMainScreenViewModel
import ru.shift.auto_impl.screen.autoMain.topbar.AutoMainScreenTopBar
import ru.shift.auto_impl.screen.autoMain.ui.AutoMainScreen
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

    ShiftScaffold(
        modifier = modifier,
        topBar = {
            AutoMainScreenTopBar(
                onNavigationClick = {}
            )
        }
    ) { paddingValues ->
        if (state.value == AutoMainScreenState.Loading) {

        } else {
            AutoMainScreen(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
            )
        }
    }
}