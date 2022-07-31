package pl.senordeveloper.template.ui.settings

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import pl.senordeveloper.template.ui.settings.Tags.TAG_CHECK_ITEM

class HintsSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Title_Displayed() {
        val title = "Show Hints"
        composeTestRule.setContent {
            HintsSettingItem(
                title = title,
                checked = true,
                onShowHintsToggled = { }
            )
        }

        composeTestRule.onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun Setting_Checked() {
        composeTestRule.setContent {
            HintsSettingItem(
                title = "Show Hints",
                checked = true,
                onShowHintsToggled = { }
            ) }
        composeTestRule
            .onNodeWithTag(TAG_CHECK_ITEM)
            .assertIsOn()
    }
}