package ru.asmelnikov.commerceshop.ui.composables.searchbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.ui.theme.LightBlack
import ru.asmelnikov.commerceshop.ui.theme.LightGrey
import ru.asmelnikov.commerceshop.ui.theme.Lightbox

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var search by remember { mutableStateOf("") }
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Lightbox,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        value = search,
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        onValueChange = { search = it },
        placeholder = {
            Text(
                text = "Search Products",
                color = LightGrey
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "",
                tint = LightBlack
            )
        }
    )
}