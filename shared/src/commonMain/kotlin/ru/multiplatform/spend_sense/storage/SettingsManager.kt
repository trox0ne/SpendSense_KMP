package ru.multiplatform.spend_sense.storage

import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SettingsManager(private val settings: Settings) {

    private val THEME_KEY = "THEME_KEY"

    var themeIsDark: Boolean
        set(value) {
            _themeIsDarkFlow.update { value }
            settings.putBoolean(THEME_KEY, value)
        }
        get() = settings.getBoolean(THEME_KEY, true)

    private val _themeIsDarkFlow = MutableStateFlow(themeIsDark)
    val themeIsDarkFlow = _themeIsDarkFlow.asStateFlow()
}