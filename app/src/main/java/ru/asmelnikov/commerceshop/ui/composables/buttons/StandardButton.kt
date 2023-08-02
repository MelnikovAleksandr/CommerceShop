package ru.asmelnikov.commerceshop.ui.composables.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.ui.theme.Orange
import ru.asmelnikov.commerceshop.ui.theme.White

@Composable
fun StandardButton(
    text: String,
    onClicked: () -> Unit,
    enabled: Boolean = true,
    elevation: ButtonElevation? = null
) {
    Button(
        onClick = onClicked,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = Orange),
        elevation = elevation,
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),

        ) {
        Text(
            text = text,
            color = White,
            style = MaterialTheme.typography.button
        )
    }
}
