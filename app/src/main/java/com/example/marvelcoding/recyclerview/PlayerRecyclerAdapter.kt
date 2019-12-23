package com.example.marvelcoding.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelcoding.activity.EspressoIdelingResources
import com.example.marvelcoding.R
import com.example.marvelcoding.database.PlayerEntity
import com.example.marvelcoding.pojo.Results
import com.example.marvelcoding.pojo.Thumbnail

class PlayerRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val TAG="Adapter"
    lateinit var contex:Context
     var resultList: List<Results>?=null
     var playersList: List<PlayerEntity>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        contex = parent.context
        return FeedViewHolder(
                LayoutInflater.from(contex).inflate(R.layout.item_view,parent,false))
    }

    override fun getItemCount(): Int {

            if (resultList!=null) {
                return resultList!!.size
            }
        else if (playersList!=null){
                return playersList!!.size
            }
          return -1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is FeedViewHolder->{

                    if (resultList!=null) {
                        holder.populate(resultList!!.get(position))
                    }
                    else if (playersList!=null){
                        holder.populatePlayer(playersList!!.get(position))
                    }
            }
        }
    }

    fun setList(resultList: List<Results>){
        EspressoIdelingResources.countingIdelingResource.increment();
        this.resultList = resultList
    }

    fun setPlayersEntity(playersList: List<PlayerEntity>){
        Log.d(TAG,"Player List entity is called ")
        this.playersList = playersList
    }



    class FeedViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

     var tvName:TextView = itemView.findViewById(R.id.tvName)
     var tvDescription:TextView = itemView.findViewById(R.id.tvDescription)
     var imageView:ImageView = itemView.findViewById(R.id.imageView)


        fun populate(result : Results){
            var thu: Thumbnail? = result.thumbnail
            var imUrl = thu?.path+"."+thu?.extension

            tvName.setText(result.name)
            tvDescription.setText(result.description)
            Glide.with(itemView.context).load(imUrl).into(imageView)
        }

        fun populatePlayer(playerEntity: PlayerEntity){
            tvName.setText(playerEntity.playerName)
            tvDescription.setText(playerEntity.playerDescription)
            Glide.with(itemView.context).load(playerEntity.imageUrl).into(imageView)
        }

    }


}