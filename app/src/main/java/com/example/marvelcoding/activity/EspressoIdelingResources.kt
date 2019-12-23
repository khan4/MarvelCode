package com.example.marvelcoding.activity

import androidx.test.espresso.idling.CountingIdlingResource

object  EspressoIdelingResources {

    private const val RESOURCE="RESOURCE"

    @JvmField val countingIdelingResource = CountingIdlingResource(RESOURCE)

    fun increment(){
        countingIdelingResource.increment()
    }

    fun decrement(){

        if (!countingIdelingResource.isIdleNow){
            countingIdelingResource.decrement()
        }

    }

}