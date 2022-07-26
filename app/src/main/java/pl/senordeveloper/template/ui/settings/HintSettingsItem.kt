package pl.senordeveloper.template.ui.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.senordeveloper.template.R

@Composable
fun HintSettingsItem(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onShowHintsToggled: (Boolean) -> Unit
) {
    val hintsEnabledState = if (checked) {
        stringResource(id = R.string.cd_hints_enabled)
    } else stringResource(id = R.string.cd_hints_disabled)

    SettingsItem(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .toggleable(
                    value = checked,
                    onValueChange = onShowHintsToggled,
                    role = Role.Checkbox
                )
                .semantics {
                    stateDescription = hintsEnabledState
                }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )
            Checkbox(
                checked = checked,
                onCheckedChange = null
            )
        }
    }
}

@Preview
@Composable
private fun HintSettingsItemPreview() {
    val checked = remember {
        mutableStateOf(true)
    }
    HintSettingsItem(
        title = "Show hints",
        checked = checked.value,
        onShowHintsToggled = {
            checked.value = it
        }
    )
}