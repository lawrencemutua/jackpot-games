package com.jackpotgameslawi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jackpotgameslawi.Model.jackpot
import com.jackpotgameslawi.R

class betikaAdapter(val context : Context, val jackpotList: List<jackpot>):
    RecyclerView.Adapter<betikaAdapter.betikaViewHolder>() {
    override fun getItemCount(): Int {
        return jackpotList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): betikaViewHolder {
        return betikaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.betika_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: betikaViewHolder, position: Int) {
        val free = jackpotList[position]
        holder.game.text = free.game
        holder.league.text = free.league
        holder.time.text = free.time
        holder.tip.text = free.tip
    }



    class betikaViewHolder (view: View): RecyclerView.ViewHolder(view){
        val league: TextView = view.findViewById(R.id.league_free)
        val game: TextView = view.findViewById(R.id.game_free)
        val time: TextView = view.findViewById(R.id.time_free)
        val tip: TextView = view.findViewById(R.id.tip_free)

    }


}