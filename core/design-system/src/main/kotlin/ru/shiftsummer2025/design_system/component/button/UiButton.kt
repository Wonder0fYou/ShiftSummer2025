package ru.shiftsummer2025.design_system.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle
import ru.shiftsummer2025.design_system.theme.ShiftTheme

enum class UiButtonStyle {
    PRIMARY,
}

@Composable
fun UiButton(
    modifier: Modifier = Modifier,
    textInButton: String,
    style: UiButtonStyle,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    isEnabled: Boolean = true,
    onClick: () -> Unit,
    underButtonContent: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (style) {
            UiButtonStyle.PRIMARY -> Button(
                modifier = Modifier,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ShiftTheme.colors.brandLeasingPrimary,
                    contentColor = ShiftTheme.colors.textInvert,
                    disabledContainerColor = ShiftTheme.colors.brandLeasingPrimary,
                    disabledContentColor = ShiftTheme.colors.textInvert
                ),
                enabled = isEnabled,
                onClick = onClick
            ) {
                ShiftText(
                    text = textInButton,
                    color = ShiftTheme.colors.textInvert,
                    textStyle = TextStyle.BUTTON
                )
            }
        }
        if (underButtonContent != null) {
            underButtonContent()
        }
    }
}