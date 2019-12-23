package com.example.marvelcoding.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Results {
    @SerializedName("id")
    @Expose
     var id: Int = 0

    @SerializedName("name")
    @Expose
     var name: String? = null

    @SerializedName("description")
    @Expose
     var description: String? = null

    @SerializedName("thumbnail")
    @Expose
     var thumbnail: Thumbnail? = null

    @SerializedName("resourceURI")
    @Expose
     var resourceUri: String? = null

    @SerializedName("comics")
    @Expose
     var comics: Comics? = null

}