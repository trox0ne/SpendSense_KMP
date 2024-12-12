package ru.multiplatform.spend_sense.settings

import ru.multiplatform.spend_sense.base.BaseViewState

class SettingsContract {
    data class State(
        val info: String,
        val themeIsDark: Boolean
    ): BaseViewState {
        companion object {
            val NONE = State(
                info = "",
                themeIsDark = false
            )
        }
    }
}