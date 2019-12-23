package com.example.marvelcoding.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {

    @SerializedName("status")
    @Expose
    var status: String?=null

    @SerializedName("copyright")
    @Expose
    var copyright:String?=null

    @SerializedName("attributionText")
    @Expose
    var attributionText:String?=null

    @SerializedName("data")
    @Expose
     var data: Data? = null

     var checkId:Int=0

}