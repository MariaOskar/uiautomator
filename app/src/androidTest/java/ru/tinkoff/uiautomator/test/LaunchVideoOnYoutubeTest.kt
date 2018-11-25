package ru.tinkoff.uiautomator.test

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.uiautomator.application.YouTube
import ru.tinkoff.uiautomator.util.getDevice

@RunWith(AndroidJUnit4::class)
class LaunchVideoOnYoutubeTest : AbstractApplicationTest<YouTube>(YouTube()) {

    @Test
    fun launchVideo() {
        getDevice().pressHome()
        app.open()
        app.clickSearch()
        app.typeToSearch("Reindeer on black paper speed drawing")
        getDevice().pressEnter()
        app.clickOnFirstVideo()

        if(app.hasAdversting()){
            Thread.sleep(5000)
            app.skipAdversting()
        }

        Thread.sleep(10000)
        app.clickOnPlayer()
        app.clickOnPause()
    }

}