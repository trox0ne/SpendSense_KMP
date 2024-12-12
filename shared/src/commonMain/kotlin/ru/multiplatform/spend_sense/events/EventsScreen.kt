package ru.multiplatform.spend_sense.events

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import ru.multiplatform.spend_sense.common.ui.calendar.compose.CalendarColors
import ru.multiplatform.spend_sense.common.ui.calendar.compose.DatePickerView
import ru.multiplatform.spend_sense.common.ui.theme.AppThemeProvider
import ru.multiplatform.spend_sense.di.getKoinInstance

@Composable
fun BoxScope.EventsScreen() {
    DatePickerView(
        viewModel = getKoinInstance(),
        colors = CalendarColors.default.copy(
            colorSurface = AppThemeProvider.colors.surface,
            colorOnSurface = AppThemeProvider.colors.onSurface,
            colorAccent = AppThemeProvider.colors.accent
        ),
        firstDayIsMonday = AppThemeProvider.appPrefs.firstDayIsMonday,
        labels = emptyList(),
        selectDayListener = { day -> }
    )
}