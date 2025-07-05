package ru.shift.auto_impl.screen.autoMain.controller

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.shift.auto_impl.di.AutoImplComponentHolder
import ru.shift.auto_impl.screen.autoMain.controller.state.AutoMainScreenState
import ru.shift.auto_impl.screen.autoMain.controller.viewmodel.AutoMainScreenViewModel
import ru.shift.auto_impl.screen.autoMain.topbar.AutoMainScreenTopBar
import ru.shift.auto_impl.screen.autoMain.ui.AutoMainScreen
import ru.shiftsummer2025.design_system.component.circularProgressIndicator.ShiftCircularProgressIndicator
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
            AutoMainScreenTopBar(
                onNavigationClick = {}
            )
        }
    ) { paddingValues ->
        if (state.value == AutoMainScreenState.Loading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ShiftCircularProgressIndicator(
                    modifier = Modifier.size(48.dp)
                )
            }
        } else {
            AutoMainScreen(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                onFiltersClick = {

                }
            )
        }
    }
}