package com.example.marvelcoding.depinjection

import com.example.marvelcoding.api.MarvelApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class ApiModule {

    @Provides
    internal fun providesMarvelApi(retrofit: Retrofit):MarvelApi{
        return retrofit.create(MarvelApi::class.java)
    }


}