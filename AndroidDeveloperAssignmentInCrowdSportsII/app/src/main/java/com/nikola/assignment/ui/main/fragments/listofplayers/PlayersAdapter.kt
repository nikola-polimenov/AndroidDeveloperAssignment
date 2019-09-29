package com.nikola.assignment.ui.main.fragments.listofplayers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikola.assignment.R
import com.nikola.assignment.models.matchmodels.Players
import kotlinx.android.synthetic.main.layout_players_list_item.view.*

class PlayersAdapter (private val clickListener:(Players) -> Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Players> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_players_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PlayerViewHolder -> {
                holder.bind(items[position], clickListener)
            }
        }
    }

    fun submitList(playersList: List<Players>) {
        val oldList = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            PlayersDiffCallback(oldList, playersList)
        )
        items = playersList
        diffResult.dispatchUpdatesTo(this)
    }

    class PlayersDiffCallback(
        private var oldListOfPlayers: List<Players>,
        private var newListOfPlayers: List<Players>
    ): DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldListOfPlayers[oldItemPosition].id == newListOfPlayers[newItemPosition].id
        }

        override fun getOldListSize(): Int {
            return oldListOfPlayers.size
        }

        override fun getNewListSize(): Int {
            return newListOfPlayers.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldListOfPlayers[oldItemPosition] == newListOfPlayers[newItemPosition]
        }

    }

    class PlayerViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        private val playerName: TextView? = itemView.player_name
        private val playerPosition: TextView? = itemView.player_position
        private val playerShirtNumber: TextView? = itemView.player_shirt_number
        private val captainStar: ImageView? = itemView.captain_star

        fun bind(player: Players, clickListener: (Players) -> Unit){
            val name = "${player.firstName} ${player.lastName}"
            if (player.captain!!) {
                captainStar?.visibility = View.VISIBLE
            }
            playerName?.text = name
            playerPosition?.text = player.position
            val shirtNumber = "Shirt Number: ${player.shirtNumber.toString()}"
            playerShirtNumber?.text = shirtNumber
            itemView.setOnClickListener {clickListener(player)}
        }
    }


}