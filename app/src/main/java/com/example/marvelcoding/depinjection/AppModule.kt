package com.example.marvelcoding.depinjection

import android.app.Application
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.marvelcoding.Constanat.Constant
import com.example.marvelcoding.R
import com.example.marvelcoding.database.PlayerDao
import com.example.marvelcoding.database.PlayerDatabse
import com.example.marvelcoding.database.PlayerDatabse.DATABASE_NAME
import com.example.marvelcoding.recyclerview.PlayerRecyclerAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    internal fun providesRetrofitInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    internal fun providesRequestOptions():RequestOptions{
        return RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
    }

    @Singleton
    @Provides
    internal fun provideRequestManager(application:Application,requestOptions: RequestOptions):RequestManager{
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }

    @Provides
    internal fun provideFeedRecyclerAdapter(): PlayerRecyclerAdapter {
        return PlayerRecyclerAdapter()
    }

}