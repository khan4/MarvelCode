package com.example.marvelcoding.api

import com.example.marvelcoding.pojo.Response
import io.reactivex.Flowable
import retrofit2.http.GET

interface MarvelApi {

    @GET("characters?ts=thesoer&apikey=001ac6c73378bbfff488a36141458af2&hash=72e5ed53d1398abb831c3ceec263f18b")
     fun getData(): Flowable<Response>
}