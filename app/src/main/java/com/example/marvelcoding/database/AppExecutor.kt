package com.example.marvelcoding.database

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutor private constructor(
        private val diskIO: Executor,
        private val networkIO: Executor

) {


    fun diskIO(): Executor{
        return diskIO
    }

    fun networkIO(): Executor{
        return networkIO
    }



    companion object{

        val LOCK=Any()
        private var instance: AppExecutor?=null

        fun getInstance(): AppExecutor{

            if(instance==null){

                synchronized(LOCK){

                    instance = AppExecutor(
                            Executors.newSingleThreadExecutor(),
                            Executors.newFixedThreadPool(3)
                    )

                }

            }
            return instance!!
        }


    }


}