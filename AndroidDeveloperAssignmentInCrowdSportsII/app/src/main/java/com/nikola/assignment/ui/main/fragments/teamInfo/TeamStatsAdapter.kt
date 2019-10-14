package com.nikola.assignment.ui.main.fragments.teamInfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikola.assignment.R
import kotlinx.android.synthetic.main.layout_team_stat_list_item.view.*

class TeamStatsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TeamStatsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_team_stat_list_item,
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
            is TeamStatsViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun submitList(teamStatsList: MutableList<String>) {
        val oldList = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            TeamStatsDiffCallback(oldList, teamStatsList)
        )
        items = teamStatsList
        diffResult.dispatchUpdatesTo(this)
    }

    class TeamStatsDiffCallback(
        private var oldListOfPlayers: List<String>,
        private var newListOfPlayers: List<String>
    ): DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldListOfPlayers[oldItemPosition] == newListOfPlayers[newItemPosition]
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

    class TeamStatsViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        private val teamStatTextView: TextView? = itemView.team_stat

        fun bind(teamStat: String){
            teamStatTextView?.text = teamStat
        }
    }


}