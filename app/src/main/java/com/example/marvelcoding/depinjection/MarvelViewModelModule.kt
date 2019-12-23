package com.example.marvelcoding.depinjection

import androidx.lifecycle.ViewModel
import com.example.marvelcoding.mvvmviewmodel.MarvelViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MarvelViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MarvelViewModel::class)
    abstract fun bindsMarvelViewModel(marvelView: MarvelViewModel):ViewModel
}