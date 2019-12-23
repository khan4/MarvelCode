package com.example.marvelcoding;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.marvelcoding.database.PlayerDao;
import com.example.marvelcoding.database.PlayerDatabse;

import org.junit.After;
import org.junit.Before;

public class PlayerDatabaseTest {


    private PlayerDatabse playerDatabse;

    public PlayerDao getPlayerDao(){
        return playerDatabse.playerDao();
    }

    @Before
    public void initTemporaryDatabaseInMemoery(){
        playerDatabse = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                PlayerDatabse.class
        ).build();
    }
    @After
    public void finishDatabase(){
        playerDatabse.close();
    }

}
