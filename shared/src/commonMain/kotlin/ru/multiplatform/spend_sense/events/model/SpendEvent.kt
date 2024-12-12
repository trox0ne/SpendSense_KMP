package ru.multiplatform.spend_sense.events.model

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import ru.multiplatform.spend_sense.extensions.now

data class SpendEvent(
    val id: String,
    val categoryId: String,
    val title: String,
    val cost: Double,
    val date: LocalDate,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime,

    ) {
    companion object {
        val NONE = SpendEvent(
            id = "",
            categoryId = "",
            title = "",
            cost = 0.0,
            date = LocalDate.now(),
            createAt = LocalDateTime.now(),
            updateAt = LocalDateTime.now()
        )
    }
    
    fun getStubs() = List(20) { index: Int ->  
        NONE.copy(
            id = index.toString(),
            title = "event $index",
            date = Clock.System.now()
                .plus(index, DateTimeUnit.DAY, TimeZone.currentSystemDefault())
                .toLocalDateTime(TimeZone.currentSystemDefault()).date
        )
    }
}