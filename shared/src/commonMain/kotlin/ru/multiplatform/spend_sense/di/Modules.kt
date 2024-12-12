package ru.multiplatform.spend_sense.di

import org.koin.dsl.module
import ru.multiplatform.spend_sense.categories.list.CategoriesViewModel
import ru.multiplatform.spend_sense.categories.model.CategoriesRepository
import ru.multiplatform.spend_sense.common.ui.calendar.DatePickerViewModel
import ru.multiplatform.spend_sense.common.ui.calendar.compose.DatePickerView
import ru.multiplatform.spend_sense.platform.DeviceInfo
import ru.multiplatform.spend_sense.root.RootViewModel
import ru.multiplatform.spend_sense.settings.SettingsViewModel
import ru.multiplatform.spend_sense.storage.SettingsManager

object CoreModule {
    val deviseInfo = module {
        single { DeviceInfo() }
    }
}

object StorageModule {
    val settings = module {
        single { SettingsManager(get()) }
    }
}

object Repositories {
    val repositores = module {
        single { CategoriesRepository() }
    }
}

object ViewModel {
    val viewModel = module {
        single { RootViewModel(get()) }
        factory { SettingsViewModel(get(), get()) }
        single { DatePickerViewModel() }
        single { CategoriesViewModel(get()) }
    }
}