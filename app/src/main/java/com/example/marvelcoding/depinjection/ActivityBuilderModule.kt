package com.example.marvelcoding.depinjection

import com.example.marvelcoding.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MarvelViewModelModule::class,ApiModule::class])
    abstract fun contributeMainActivity(): MainActivity
}