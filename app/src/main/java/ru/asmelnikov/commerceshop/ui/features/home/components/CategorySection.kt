package ru.asmelnikov.commerceshop.ui.features.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.asmelnikov.commerceshop.common.preview.PreviewData
import ru.asmelnikov.commerceshop.domain.models.Category
import ru.asmelnikov.commerceshop.ui.composables.cards.CategoryCard


@Composable
fun CategorySection(
    categories: List<Category>,
    categorySelected: (category: Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories, key = { it.id }) { category ->
            CategoryCard(category, categorySelected)
        }
    }
}

@Preview
@Composable
fun PreviewCategorySection() {
    CategorySection(
        categories = PreviewData.categories(),
        categorySelected = {}
    )
}