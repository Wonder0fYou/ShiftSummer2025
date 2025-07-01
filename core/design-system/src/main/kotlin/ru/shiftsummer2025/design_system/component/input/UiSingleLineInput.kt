package ru.shiftsummer2025.design_system.component.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.shiftsummer2025.design_system.component.iconItem.ActionIconItem
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle

@Composable
fun UiSingleLineInput(
    modifier: Modifier = Modifier,
    text: String,
    placeholderText: String? = null,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    trailingIconItem: ActionIconItem? = null,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    onTextChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = text,
            singleLine = singleLine,
            shape = shape,
            readOnly = readOnly,
            placeholder = placeholderText?.let {
                {
                    ShiftText(
                        text = placeholderText,
                        textStyle = TextStyle.BODY_REGULAR_16
                    )
                }
            },
            onValueChange = {
                onTextChange(it)
            },
            trailingIcon = trailingIconItem?.let {
                {
                    IconButton(onClick = it.onClick) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = it.iconRes),
                            contentDescription = it.contentDescription
                        )
                    }
                }
            }
        )
    }
}