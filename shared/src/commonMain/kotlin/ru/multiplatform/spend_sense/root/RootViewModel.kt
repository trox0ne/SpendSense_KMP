package ru.multiplatform.spend_sense.root

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.multiplatform.spend_sense.base.BaseViewModel
import ru.multiplatform.spend_sense.root.model.AppTab
import ru.multiplatform.spend_sense.root.model.RootContract
import ru.multiplatform.spend_sense.storage.SettingsManager

class RootViewModel(
    private val settingsManager: SettingsManager
): BaseViewModel<RootContract.State, Nothing>() {
    init {
        settingsManager.themeIsDarkFlow.onEach { isDark ->
            updateState { copy(themeIsDark = isDark) }
        }.launchIn(viewModelScope)
    }

    override fun initialState(): RootContract.State = RootContract.State.NONE

    fun handleClickOnTab(appTab: AppTab) = updateState { copy(selectedTab = appTab) }

}