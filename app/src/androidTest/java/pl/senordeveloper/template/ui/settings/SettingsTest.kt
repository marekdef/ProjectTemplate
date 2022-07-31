package pl.senordeveloper.template.ui.settings

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test

import pl.senordeveloper.template.R
import pl.senordeveloper.template.ui.settings.Tags.TAG_CHECK_ITEM
import pl.senordeveloper.template.ui.settings.Tags.TAG_TOGGLE_ITEM

internal class SettingsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Enable_Notifications_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_enable_notifications)
    }

    @Test
    fun Show_Hints_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_show_hints
        )
    }

    @Test
    fun View_Subscription_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_manage_subscription)
    }

    @Test
    fun App_Version_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.app_version)
    }

    @Test
    fun Theme_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_option_theme)
    }

    @Test
    fun Marketing_Options_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_option_marketing)
    }

    @Test
    fun Enable_Notifications_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(
                    R.string.setting_enable_notifications
                )
        ).performClick()

        composeTestRule.onNodeWithTag(
            TAG_TOGGLE_ITEM
        ).assertIsOn()
    }

    @Test
    fun Show_Hints_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.setting_show_hints)
        ).performClick()

        composeTestRule.onNodeWithTag(
            TAG_CHECK_ITEM
        ).assertIsOn()
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
}