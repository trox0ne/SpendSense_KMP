package ru.multiplatform.spend_sense.categories.model

import kotlinx.datetime.LocalDateTime
import ru.multiplatform.spend_sense.extensions.now

data class Category(
    val id: String,
    val title: String,
    val description: String,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val colorHex: String
) {
    companion object {
        val NONE = Category(
            id = "NONE_CATEGORY",
            title = "",
            description = "",
            createAt = LocalDateTime.now(),
            updateAt = LocalDateTime.now(),
            colorHex = ""
        )
    }
}