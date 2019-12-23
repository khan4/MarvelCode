package com.example.marvelcoding;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.marvelcoding.database.PlayerEntity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class PlayerDaoTest extends PlayerDatabaseTest {


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();

    @Test
    public void insertReadTest() throws  Exception {

        PlayerEntity playerEntity = new PlayerEntity(1,"BatMan","http","hero");

        //Insert
        getPlayerDao().insert(playerEntity).blockingGet();


        LiveDataTestUtil<List<PlayerEntity>> liveDataTestUtil= new LiveDataTestUtil<>();

        //Read
        List<PlayerEntity> insertedPlayer = liveDataTestUtil.getValue(getPlayerDao().getAll());

        assertNotNull(insertedPlayer);
        assertEquals(playerEntity.getPlayerId(),insertedPlayer.get(0).getPlayerId());
        assertEquals(playerEntity.getPlayerName(),insertedPlayer.get(0).getPlayerName());
        assertEquals(playerEntity.getImageUrl(),insertedPlayer.get(0).getImageUrl());
        assertEquals(playerEntity.getPlayerDescription(),insertedPlayer.get(0).getPlayerDescription());


    }
}
