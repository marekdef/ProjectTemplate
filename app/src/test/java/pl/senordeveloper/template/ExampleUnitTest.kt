package pl.senordeveloper.template

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.senordeveloper.template.settings.SettingsViewModel
import pl.senordeveloper.template.ui.SettingsState

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val settingsViewModel = SettingsViewModel()

        assertEquals(settingsViewModel.uiState.value, SettingsState())
    }
}