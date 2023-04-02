package com.jackpotgameslawi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jackpotgameslawi.Model.game
import com.jackpotgameslawi.R

class safePicksAdapter(val context: Context, val gameList: List<game>):
    RecyclerView.Adapter<safePicksAdapter.safePicksViewHolder>() {

    override fun getItemCount(): Int {
        return gameList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): safePicksViewHolder {
        return safePicksViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.safe_row, parent,false)
        )
    }

    override fun onBindViewHolder(holder: safePicksViewHolder, position: Int) {
        val free = gameList[position]
        holder.awayTeam.text =free.awayTeam
        holder.odd.text = free.odd
        holder.tip.text = free.tip
        holder.homeTeam.text = free.homeTeam
        holder.leagueTime.text = free.leagueTime
        holder.result.text = free.result
        Glide.with(context)
            .load(free.awayTeamImage)
            .into(holder.awayTeamImage)
        Glide.with(context)
            .load(free.homeTeamImage)
            .into(holder.homeTeamImage)
    }



    class safePicksViewHolder(view: View):RecyclerView.ViewHolder(view){
        val leagueTime: TextView = view.findViewById(R.id.leagueTime)
        val awayTeam: TextView = view.findViewById(R.id.awayTeam)
        val homeTeam: TextView = view.findViewById(R.id.homeTeam)
        val tip: TextView = view.findViewById(R.id.tip)
        val result: TextView = view.findViewById(R.id.result)
        val odd: TextView = view.findViewById(R.id.odd)
        val awayTeamImage: ImageView = view.findViewById(R.id.awayTeamImage)
        val homeTeamImage: ImageView = view.findViewById(R.id.homeTeamImage)

    }

}