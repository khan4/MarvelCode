package com.example.marvelcoding

import com.example.marvelcoding.database.PlayerEntity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotSame
import org.junit.Assert
import org.junit.Test

class PlayerEntityTest {


    @Test
    fun isPlayerEntityEqual(){
        var player1 = PlayerEntity(1,"Batman","http","description")
        var player2 = PlayerEntity(1,"Batman","http","description")
        assertEquals(player1,player2)
    }

    @Test
    fun isPlayerNotEqual(){
        var player1 = PlayerEntity(2,"SuperMan","https","Hero")
        var player2 = PlayerEntity(3,"Superman","https","Hero")
        assertNotSame(player1,player2)
    }

    @Test
    fun isPlayerNoteEqual_differentNAmes(){

        var player1 = PlayerEntity(1,"SuperMan","http","Best")
        var player2 = PlayerEntity(1,"BatMan","http","Best")
        assertNotSame(player1,player2)
    }

    @Test
    fun isPlayerNoteEqual_differentUrls(){
        var player1 = PlayerEntity(1,"SuperMan","https//","Best")
        var player2 = PlayerEntity(1,"BatMan","http","Best")
        assertNotSame(player1,player2)
    }
    @Test
    fun isPlayerNoteEqual_differentDescription(){
        var player1 = PlayerEntity(1,"SuperMan","http","Supper Dooper")
        var player2 = PlayerEntity(1,"BatMan","http","Best")
        assertNotSame(player1,player2)
    }

}