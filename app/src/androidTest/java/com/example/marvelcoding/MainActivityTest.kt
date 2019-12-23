package com.example.marvelcoding

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.marvelcoding.activity.EspressoIdelingResources
import com.example.marvelcoding.activity.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    val TAG="Test"

    @get: Rule
    val activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun registerIdelingResources(){
      IdlingRegistry.getInstance().register(EspressoIdelingResources.countingIdelingResource)
    }

    @After
    fun unRegisterResource(){
        IdlingRegistry.getInstance().unregister(EspressoIdelingResources.countingIdelingResource)
    }

    @Test
    fun isActivityLaunchedProperly(){
        onView(withId(R.id.main)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

    }


}