package com.example.marvelcoding.database

import android.app.Application
import androidx.lifecycle.LiveData

class Repository(application: Application) {


    private var database:PlayerDatabse = PlayerDatabse.getInstance(application)
    private var playerDao:PlayerDao = database.playerDao()
    private var playerList: LiveData<List<PlayerEntity>> = playerDao.getAll()



    fun insertPlayer(playerEntity: PlayerEntity){
        AppExecutor.getInstance().diskIO().execute(Runnable {
            playerDao.insert(playerEntity)
        })
    }

    fun deletePlayer(deletePlayer : PlayerEntity){
        AppExecutor.getInstance().diskIO().execute(Runnable {
            playerDao.deletePlayer(deletePlayer)
        })
    }

    fun deleteAllPlayers(playersList:List<PlayerEntity>){
        AppExecutor.getInstance().diskIO().execute(Runnable {
            playerDao.deleteAllPlayers(playersList)
        })
    }

    fun getAllPlayers() :LiveData<List<PlayerEntity>>{

        return playerList
    }

}



