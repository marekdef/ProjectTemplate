package pl.senordeveloper.template.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pl.senordeveloper.template.BuildConfig
import pl.senordeveloper.template.R
import pl.senordeveloper.template.ui.MarketingOption
import pl.senordeveloper.template.ui.SettingsState
import pl.senordeveloper.template.ui.Theme

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onNotificationSettingsChange: (Boolean) -> Unit,
    onHintSettingsChange: (Boolean) -> Unit,
    onOptionSelected: (MarketingOption) -> Unit,
    onThemeSelected: (Theme) -> Unit
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        TopAppBar()
        NotificationSettings(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.title_notifications),
            checked = state.notificationsEnabled,
            onCheckedChange = onNotificationSettingsChange
        )
        Divider()
        HintSettingsItem(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.setting_show_hints),
            checked = state.hintsEnabled,
            onShowHintsToggled = onHintSettingsChange
        )
        Divider()
        ManageSubscriptionSettingItem(
            title = stringResource(id = R.string.setting_manage_subscription),
            onSettingClicked = {
            }
        )
        SectionSpacer(modifier = Modifier.fillMaxWidth())
        MarketingSettingItem(
            modifier = Modifier.fillMaxWidth(),
            selectedOption = state.marketingOption,
            onOptionSelected = onOptionSelected
        )
        Divider()
        ThemeSettingItem(
            modifier = Modifier.fillMaxWidth(),
            selectedTheme = state.themeOption,
            onThemeSelected = onThemeSelected
        )
        SectionSpacer(modifier = Modifier.fillMaxWidth())
        AppVersionSettingItem(appVersion = BuildConfig.VERSION_NAME)
    }
}

@Preview
@Composable
private fun SettingsListPreview() {
    SettingsList(
        state = SettingsState(),
        onNotificationSettingsChange = {},
        onHintSettingsChange = {},
        onOptionSelected = {},
        onThemeSelected = {}
    )
}