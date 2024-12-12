package ru.multiplatform.spend_sense.common.ui.calendar.model

data class CalendarWeek(
    val days: List<CalendarDay>
) {
    companion object {
        private const val countWeeks = 7
        private const val countDays = 6
        val PLACEHOLDER = List(countWeeks) {
            CalendarWeek(days = List(countDays) { CalendarDay.NONE})
        }
    }
}
