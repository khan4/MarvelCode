package com.example.marvelcoding.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Items {
    @SerializedName("resourceURI")
    @Expose
    private var resourceURI: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null
}