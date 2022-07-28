package pl.senordeveloper.template.ui

import androidx.annotation.StringRes
import pl.senordeveloper.template.R

enum class Theme(@StringRes val label: Int) {
    LIGHT(R.string.theme_light),
    DARK(R.string.theme_dark),
    SYSTEM(R.string.theme_system)
}