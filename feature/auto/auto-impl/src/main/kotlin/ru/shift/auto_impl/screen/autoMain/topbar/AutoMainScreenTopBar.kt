package ru.shift.auto_impl.screen.autoMain.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.shiftsummer2025.design_system.component.topbar.model.TopBarConfiguration
import ru.shiftsummer2025.design_system.component.topbar.ui.ShiftCenterAlignedTopBar
import ru.shiftsummer2025.design_system.component.topbar.ui.TopBarTitleWithText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoMainScreenTopBar(
    modifier: Modifier = Modifier,
) {
    val topBarConfiguration = TopBarConfiguration(
        title = {
            TopBarTitleWithText(text = "Автомобили")
        },
    )
    ShiftCenterAlignedTopBar(
        modifier = modifier,
        topBarConfiguration = topBarConfiguration
    )
}