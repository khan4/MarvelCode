package com.example.marvelcoding.resource

import android.content.ContentValues.TAG
import android.util.Log

class Resource<T>(val status: Status, val data: T?, val message: String?) {

    val TAG="Resource"
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T?): Resource<T> {
            Log.d(TAG,"Sucess is called")
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}