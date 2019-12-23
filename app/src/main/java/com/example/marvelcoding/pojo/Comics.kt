package com.example.marvelcoding.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comics {
    @SerializedName("collectionURI")
    @Expose
    private val collectionUri: String? = null

    @SerializedName("Items")
    @Expose
    private val itemsList: List<Items>? = null
}