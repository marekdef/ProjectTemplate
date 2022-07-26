package pl.senordeveloper.template.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.senordeveloper.template.R
import pl.senordeveloper.template.ui.SettingsState

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onNotificationSettingsChange: (Boolean) -> Unit = {},
    onHintSettingsChange: (Boolean) -> Unit = {}
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentPadding = PaddingValues(start = 12.dp)
        ) {
            Row {
                Icon(
                    tint = MaterialTheme.colors.onSurface,
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(
                        id = R.string.cd_go_back
                    )
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(id = R.string.title_settings),
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 18.sp,
                )
            }
        }
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
    }
}

@Preview
@Composable
private fun SettingsListPreview() {
    SettingsList(state = SettingsState())
}