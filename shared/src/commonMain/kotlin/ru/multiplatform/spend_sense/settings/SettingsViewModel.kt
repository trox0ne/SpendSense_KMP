package ru.multiplatform.spend_sense.settings

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.multiplatform.spend_sense.base.BaseViewModel
import ru.multiplatform.spend_sense.platform.DeviceInfo
import ru.multiplatform.spend_sense.storage.SettingsManager

class SettingsViewModel(
    private val deviceInfo: DeviceInfo,
    private val settingsManager: SettingsManager
): BaseViewModel<SettingsContract.State, Nothing> () {

    init {
        settingsManager.themeIsDarkFlow.onEach {
            updateState { copy(themeIsDark = it) }
        }.launchIn(viewModelScope)

        updateState {
            copy(info = deviceInfo.getSummary())
        }
    }

    override fun initialState(): SettingsContract.State = SettingsContract.State.NONE

    fun switchTheme(isDark: Boolean) {
        settingsManager.themeIsDark = isDark
    }
}