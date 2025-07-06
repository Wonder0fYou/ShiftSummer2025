package ru.shiftsummer2025.design_system.component.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.shiftsummer2025.design_system.component.text.ShiftText
import ru.shiftsummer2025.design_system.component.text.TextStyle
import ru.shiftsummer2025.design_system.theme.ShiftTheme

@Composable
fun ShiftCarMainCard(
    modifier: Modifier = Modifier,
    urlImage: String,
    autoName: String,
    transmission: String,
    price: Int
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardColors(
            contentColor = Color.Unspecified,
            containerColor = ShiftTheme.colors.backgroundPrimary,
            disabledContentColor = Color.Unspecified,
            disabledContainerColor = Color.Unspecified,
        )
    ) {
        Column (
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ){
            Row (
                modifier = Modifier
            ){
                AsyncImage(
                    modifier = Modifier
                        .width(170.dp)
                        .height(116.dp)
                        .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)),
                    model = urlImage,
                    contentScale = ContentScale.Crop,
                    contentDescription = "фото авто"
                )
                Column(
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp,
                        )
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    ShiftText(
                        text = autoName,
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                    ShiftText(
                        text = transmission,
                        textStyle = TextStyle.PARAGRAPH_12
                    )
                    ShiftText(
                        text = "$price ₽",
                        textStyle = TextStyle.PARAGRAPH_16
                    )
                    ShiftText(
                        text = (price * 14).toString() + " ₽" + " за 14 дней",
                        textStyle = TextStyle.PARAGRAPH_12
                    )
                }
            }
        }
    }
}