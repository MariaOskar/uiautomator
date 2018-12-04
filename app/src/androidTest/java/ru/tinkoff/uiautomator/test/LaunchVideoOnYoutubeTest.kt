package ru.tinkoff.uiautomator.test

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.uiautomator.application.YouTube
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiObject2
import ru.tinkoff.uiautomator.util.*
import java.util.concurrent.TimeUnit


const val SEARCH_QUERY = "Reindeer on black paper speed drawing"

@RunWith(AndroidJUnit4::class)
class LaunchVideoOnYoutubeTest : AbstractApplicationTest<YouTube>(YouTube()) {

    @Test
    fun launchVideo() {
        getDevice().pressHome()
        app.open()
        app.clickSearch()
        app.typeToSearch(SEARCH_QUERY)
        getDevice().pressEnter()
        app.clickOnFirstVideo()

        if(app.hasAdversting()){
            app.skipAdversting()
        }

        app.waitTenSeconds()
        app.clickOnPlayer()
        app.clickOnPause()
    }

}