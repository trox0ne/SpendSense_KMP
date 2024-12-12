package ru.multiplatform.spend_sense.categories.creation

import kotlinx.datetime.LocalDateTime
import ru.multiplatform.spend_sense.categories.model.Category
import ru.multiplatform.spend_sense.platform.randomUUID

data class CreateCategoryData(
    val title: String,
    val subtitle: String,
    val colorHex: String
)


fun CreateCategoryData.toCategory(dateTime: LocalDateTime): Category = Category(
    id = randomUUID(),
    title = title,
    description = subtitle,
    colorHex = colorHex,
    createAt = dateTime,
    updateAt = dateTime
)