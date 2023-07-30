package ru.asmelnikov.commerceshop.ui.patterns

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.ui.theme.Orange

@Composable
fun CommerceShopBottomBar() {

    val selectIndex = remember {
        mutableStateOf(0)
    }

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background),
        elevation = 10.dp
    ) {
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "")
            },
            label = { Text(text = "Home") },
            selected = (selectIndex.value == 0),
            unselectedContentColor = Color.Gray,
            selectedContentColor = Orange,
            onClick = {
                selectIndex.value = 0
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
            },
            label = { Text(text = "Cart") },
            selected = (selectIndex.value == 1),
            unselectedContentColor = Color.Gray,
            selectedContentColor = Orange,
            onClick = {
                selectIndex.value = 1
            }
        )
    }
}