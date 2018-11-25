package ru.tinkoff.uiautomator.application

import androidx.test.uiautomator.By
import ru.tinkoff.uiautomator.util.*

class YouTube : AbstractApplication("com.google.android.youtube"){

    fun clickSearch() {
        byContentDesc("Введите запрос").waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        byStringRes("com.google.android.youtube:id/search_edit_text").waitFindObject().text = text
    }

    fun clickOnFirstVideo() {
        byStringRes("com.google.android.youtube:id/results")
            .waitFindObject()
            .children.get(0)
            .findObject(By.res("com.google.android.youtube:id/title")).click()
    }

    fun clickOnPause() {
        byStringRes("com.google.android.youtube:id/player_control_play_pause_replay_button").waitFindObject().click()
    }

    fun clickOnPlayer() {
        byStringRes("com.google.android.youtube:id/player_view").waitFindObject().click()
    }

    fun hasAdversting():Boolean = byStringText("На сайт рекламодателя").waitHasObject()

    fun skipAdversting(){
        byStringRes("com.google.android.youtube:id/skip_ad_button_text").waitFindObject().click()
    }

}