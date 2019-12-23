package com.example.marvelcoding.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "PlayersInfo")
data class PlayerEntity (
        @PrimaryKey(autoGenerate = false)
        val playerId:Int,

        @ColumnInfo(name = "Col_Player_Name")
        val playerName:String,

        @ColumnInfo(name = "Col_Player_Image")
        val imageUrl:String,

        @ColumnInfo(name = "Col_Player_Description")
        val playerDescription:String
) :Parcelable {



        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(playerId)
                parcel.writeString(playerName)
                parcel.writeString(imageUrl)
                parcel.writeString(playerDescription)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<PlayerEntity> {
                override fun createFromParcel(parcel: Parcel): PlayerEntity {
                        return PlayerEntity(parcel)
                }

                override fun newArray(size: Int): Array<PlayerEntity?> {
                        return arrayOfNulls(size)
                }
        }

        override fun equals(other: Any?): Boolean {
                if (other==null){
                        return false
                }
                if (javaClass!=other.javaClass){
                        return false
                }
                var entity:PlayerEntity = other as PlayerEntity

                return entity.playerId ==playerId && entity.playerName== playerName

        }
}