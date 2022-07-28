package pl.senordeveloper.template.ui.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.senordeveloper.template.settings.SettingsViewModel

@Preview
@Composable
fun Settings() {
    val viewModel: SettingsViewModel = viewModel()
    val state = viewModel.uiState.collectAsState().value

    SettingsList(
        state = state,
        onNotificationSettingsChange = {
            viewModel.toggleNotificationSettings()
        },
        onHintSettingsChange = {
            viewModel.toggleHintSettings()
        },
        onOptionSelected = viewModel::setMarketingSettings,
        onThemeSelected = viewModel::setTheme
    )
}