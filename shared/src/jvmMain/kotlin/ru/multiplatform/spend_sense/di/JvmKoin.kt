package ru.multiplatform.spend_sense.di

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.module
import java.util.prefs.Preferences

actual val platformModule = module {
    single<Settings> { PreferencesSettings(Preferences.userRoot())  }
}