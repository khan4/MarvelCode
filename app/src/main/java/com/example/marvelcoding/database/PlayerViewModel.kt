package com.example.marvelcoding.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class PlayerViewModel(application: Application): AndroidViewModel(application) {

    private var repository:Repository = Repository(application)
     var playerList:LiveData<List<PlayerEntity>> = repository.getAllPlayers()

    fun insert(playerEntity: PlayerEntity){
        repository.insertPlayer(playerEntity)
    }

    fun observerPlayers()=playerList

}