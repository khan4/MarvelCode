package com.example.marvelcoding.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("limit")
    @Expose
     var limit: Int = 0

    @SerializedName("total")
    @Expose
     var total: Int = 0

    @SerializedName("results")
    @Expose
     var results: List<Results>? = null


}