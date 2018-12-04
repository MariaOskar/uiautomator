package ru.tinkoff.uiautomator.application

import androidx.test.uiautomator.By
import androidx.test.uiautomator.EventCondition
import androidx.test.uiautomator.Until
import ru.tinkoff.uiautomator.util.*
import java.util.concurrent.TimeUnit

class YouTube : AbstractApplication("com.google.android.youtube"){

    private val ADS_LINK_TEXT = "На сайт рекламодателя"
    private val SEARCH_FIELD_PLACEHOLDER = "Введите запрос"
    private val SEARCH_RESULTS_RESOURCE = "com.google.android.youtube:id/results"
    private val PLAYER_VIEW_RESOURCE = "com.google.android.youtube:id/player_view"
    private val SEARCH_FIELD_RESOURCE = "com.google.android.youtube:id/search_edit_text"
    private val SEARCH_RESULT_TITLE_RESOURCE = "com.google.android.youtube:id/title"
    private val PLAY_AND_PAUSE_BUTTON_RESOURCE = "com.google.android.youtube:id/player_control_play_pause_replay_button"
    private val SKIP_ADD_BUTTON_RESOURCE = "com.google.android.youtube:id/skip_ad_button_text"
    private val SEEKBAR_CLASS = "android.widget.SeekBar"
    private val AD_SKIP_BUTTON_SELECTOR = byStringRes(SKIP_ADD_BUTTON_RESOURCE)

    fun clickSearch() {
        byContentDesc(SEARCH_FIELD_PLACEHOLDER).waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        byStringRes(SEARCH_FIELD_RESOURCE).waitFindObject().text = text
    }

    fun clickOnFirstVideo() {
        byStringRes(SEARCH_RESULTS_RESOURCE)
            .waitFindObject()
            .children.get(0)
            .findObject(By.res(SEARCH_RESULT_TITLE_RESOURCE)).click()
    }

    fun clickOnPause() {
        byStringRes(PLAY_AND_PAUSE_BUTTON_RESOURCE).waitFindObject().click()
    }

    fun clickOnPlayer() {
        byStringRes(PLAYER_VIEW_RESOURCE).waitFindObject().click()
    }

    fun hasAdversting():Boolean = byStringText(ADS_LINK_TEXT).waitHasObject()

    fun skipAdversting(){
        if(AD_SKIP_BUTTON_SELECTOR.waitHasObject()){
            AD_SKIP_BUTTON_SELECTOR.waitFindObject().click()
        }
    }

    fun waitTenSeconds(){
        val element = byClass(SEEKBAR_CLASS).waitFindObject()
        element.wait(
            Until.descContains("0:10 из "),
            TimeUnit.SECONDS.toMillis(20)
        )
    }
}