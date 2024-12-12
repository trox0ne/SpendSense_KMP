package ru.multiplatform.spend_sense.root.model

import ru.multiplatform.spend_sense.base.BaseViewState
import ru.multiplatform.spend_sense.common.ui.theme.AppPrefs

class RootContract {
    data class State(
        val themeIsDark: Boolean,
        val firstDayIsMonday: Boolean,
        val selectedTab: AppTab
    ) : BaseViewState {

        val appPrefs: AppPrefs
            get() = AppPrefs(firstDayIsMonday = firstDayIsMonday)

        companion object {
            val NONE = State(
                themeIsDark = true,
                firstDayIsMonday = true,
                selectedTab = AppTab.Events
            )
        }
    }
}