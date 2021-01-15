package com.example.madlevel5task2.Game

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.SimpleDateFormat


class GamesAdapter(private val games: List<Game>) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SimpleDateFormat")
        fun databind(game: Game) {
            val format = SimpleDateFormat("dd MMMM yyyy")

                itemView.gameTitle.text = game.title
                itemView.tvgamePlatfrom.text = game.platform
                itemView.tvgameDate.text = String.format("Release: %s", format.format(game.date))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }

}