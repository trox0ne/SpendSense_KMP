package ru.multiplatform.spend_sense.root.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ru.multiplatform.spend_sense.categories.CategoriesScreen
import ru.multiplatform.spend_sense.common.ui.theme.AppTheme
import ru.multiplatform.spend_sense.common.ui.theme.AppThemeProvider
import ru.multiplatform.spend_sense.di.getKoinInstance
import ru.multiplatform.spend_sense.events.EventsScreen
import ru.multiplatform.spend_sense.root.RootViewModel
import ru.multiplatform.spend_sense.root.model.AppTab
import ru.multiplatform.spend_sense.settings.compose.SettingsScreen
import ru.multiplatform.spend_sense.settings.SettingsViewModel

@Composable
fun RootScreen() {
    val viewModel = getKoinInstance<RootViewModel>()
    val state by viewModel.state.collectAsState()

    AppTheme(
        themeIsDark = state.themeIsDark,
        appPrefs = state.appPrefs
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(AppThemeProvider.colors.background)) {

            RootNavigation(state.selectedTab)
            RootBottomBar(state.selectedTab) { tab ->
                viewModel.handleClickOnTab(tab)
            }
        }
    }
}

@Composable
fun BoxScope.RootNavigation(selectedTab: AppTab) {
    when (selectedTab) {
        AppTab.Categories -> CategoriesScreen()
        AppTab.Events -> EventsScreen()
        AppTab.Settings -> SettingsScreen(SettingsViewModel(getKoinInstance(), getKoinInstance()))
    }
}