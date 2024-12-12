package ru.multiplatform.spend_sense.categories.list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.multiplatform.spend_sense.categories.model.Category
import ru.multiplatform.spend_sense.common.ui.atoms.ColorLabel
import ru.multiplatform.spend_sense.common.ui.theme.AppThemeProvider

@Composable
fun CategoryItem(category: Category, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(AppThemeProvider.colors.surface)
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f).padding(end = 16.dp)
        ) {
            Text(
                text = category.title,
                fontSize = 22.sp,
                color = AppThemeProvider.colors.onSurface
            )

            if (category.description.isNotBlank()) {
                Text(
                    text = category.description,
                    fontSize = 18.sp,
                    color = AppThemeProvider.colors.onSurface.copy(0.7f)
                )
            }
        }

        ColorLabel(category.colorHex)
    }
}