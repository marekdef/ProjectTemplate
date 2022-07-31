package pl.senordeveloper.template.ui.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.senordeveloper.template.R

@Composable
fun AppVersionSettingItem(
    modifier: Modifier = Modifier,
    appVersion: String
) {

    SettingsItem(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
                .semantics(mergeDescendants = true) {
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(id = R.string.app_version),
            )
            Text(
                text = appVersion,
            )
        }
    }
}

@Preview
@Composable
private fun AppVersionSettingItemPreview() {
    AppVersionSettingItem(
        appVersion = "0.0.0"
    )
}