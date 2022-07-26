package pl.senordeveloper.template.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import pl.senordeveloper.template.ui.MarketingOption
import pl.senordeveloper.template.ui.SettingsState
import pl.senordeveloper.template.ui.Theme

class SettingsViewModel : ViewModel() {
    val uiState = MutableStateFlow(SettingsState())

    fun toggleNotificationSettings() {
        uiState.value = uiState.value.copy(
            notificationsEnabled = !
            uiState.value.notificationsEnabled
        )
    }

    fun toggleHintSettings() {
        uiState.value = uiState.value.copy(
            hintsEnabled = !
            uiState.value.hintsEnabled
        )
    }

    fun setMarketingSettings(option: MarketingOption) {
        uiState.value = uiState.value.copy(
            marketingOption = option
        )
    }

    fun setTheme(theme: Theme) {
        uiState.value = uiState.value.copy(themeOption = theme)
    }
}