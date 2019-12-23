package com.example.marvelcoding.database

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Single
import android.provider.ContactsContract.CommonDataKinds.Note



@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Throws(Exception::class)
    fun insert(playerEntity: PlayerEntity):Single<Long>

    @Query("SELECT * FROM PlayersInfo")
    fun getAll(): LiveData<List<PlayerEntity>>

    @Query("SELECT * FROM PlayersInfo WHERE playerId= :playerId")
    fun findPlayer(playerId:Int):PlayerEntity


    @Delete
    fun deletePlayer(playerEntity: PlayerEntity)

    @Delete
    fun deleteAllPlayers(players:List<PlayerEntity>)

}