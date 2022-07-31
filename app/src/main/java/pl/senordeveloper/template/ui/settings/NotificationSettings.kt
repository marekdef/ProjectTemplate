package pl.senordeveloper.template.ui.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.senordeveloper.template.R
import pl.senordeveloper.template.ui.settings.Tags.TAG_TOGGLE_ITEM

@Composable
fun NotificationSettings(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean = false,
    onCheckedChange: ((checked: Boolean) -> Unit) = {}
) {
    val notificationsEnabledState = if (checked) {
        stringResource(id = R.string.cd_notifications_enabled)
    } else stringResource(id = R.string.cd_notifications_disabled)

    SettingItem(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .testTag(TAG_TOGGLE_ITEM)
                .toggleable(
                    value = checked,
                    onValueChange = onCheckedChange,
                    role = Switch
                )
                .semantics {
                    stateDescription = notificationsEnabledState
                }
                .padding(16.dp),
            verticalAlignment = CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = checked,
                onCheckedChange = null
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    NotificationSettings(title = "Enable notifications")
}