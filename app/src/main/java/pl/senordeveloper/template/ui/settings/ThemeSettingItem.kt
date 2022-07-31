package pl.senordeveloper.template.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import pl.senordeveloper.template.R
import pl.senordeveloper.template.ui.Theme

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onThemeSelected: (Theme) -> Unit
) {
    SettingsItem(modifier = modifier) {
        var expanded by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .clickable(
                    onClick = { expanded = !expanded },
                    onClickLabel = stringResource(id = R.string.cd_select_theme)

                )
                .padding(16.dp),
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.setting_option_theme)
            )
            Text(text = stringResource(id = selectedTheme.label))
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 0.dp)
        ) {

            Theme.values().forEach { theme ->
                DropdownMenuItem(onClick = {
                    onThemeSelected(theme)
                    expanded = false
                }) {
                    Text(text = stringResource(id = theme.label))
                }
            }
        }
    }
}

@Preview
@Composable
private fun ThemeSettingItemPreview() {
    ThemeSettingItem(
        selectedTheme = Theme.LIGHT,
        onThemeSelected = { }
    )
}