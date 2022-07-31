package pl.senordeveloper.template.ui.settings

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test

import pl.senordeveloper.template.R

internal class SettingsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Enable_Notifications_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.title_notifications)
    }

    @Test
    fun Show_Hints_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_show_hints)
    }
    @Test
    fun View_Subscription_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_manage_subscription)
    }

    @Test
    fun App_Version_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.app_version)
    }

    @Test
    fun Theme_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_option_theme)
    }
    @Test
    fun Marketing_Options_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_option_marketing)
    }


    private fun assertSettingIsDisplayed(
        @StringRes titleId: Int
    ) {
        composeTestRule.setContent {
            Settings()
        }

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(titleId)
        ).assertIsDisplayed()
    }

    @Test
    fun Enable_Notifications_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(
                    R.string.setting_enable_notifications)
        ).performClick()
    }
}