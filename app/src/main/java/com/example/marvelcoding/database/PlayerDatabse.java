package com.example.marvelcoding.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PlayerEntity.class},version = 1,exportSchema = false)
public abstract class PlayerDatabse extends RoomDatabase {
    private static PlayerDatabse instance;
    private static final Object LOCK=new Object();
    public static final String DATABASE_NAME="PlayerDb";


    public static PlayerDatabse getInstance(Context context){
        if (instance==null){
            synchronized (LOCK){
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        PlayerDatabse.class,DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return instance;
    }

    public abstract PlayerDao playerDao();

}
