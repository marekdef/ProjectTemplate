package pl.senordeveloper.template.ui

import pl.senordeveloper.template.ui.MarketingOption.ALLOWED
import pl.senordeveloper.template.ui.Theme.SYSTEM

data class SettingsState(
    val notificationsEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = ALLOWED,
    val themeOption: Theme = SYSTEM
)



