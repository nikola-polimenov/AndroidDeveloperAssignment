package com.nikola.assignment.ui.main.fragments.listofplayers

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.nikola.assignment.R
import com.nikola.assignment.models.matchmodels.Players
import com.nikola.assignment.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_list_of_players.*

class ListOfPlayersFragment : Fragment() {
    private lateinit var listOfPlayersViewModel: ListOfPlayersViewModel
    private lateinit var playersAdapter: PlayersAdapter
    private val logTag = "ListOfPlayersFragment Testing:"
    private var feedMatchId = 0
    private var team = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listOfPlayersViewModel = ViewModelProviders.of(this).get(ListOfPlayersViewModel::class.java)
        return inflater.inflate(R.layout.fragment_list_of_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        feedMatchId = activity?.intent?.extras?.get("feedMatchId") as Int
        team = arguments?.get("team") as String
        Log.d(logTag, "This should give the feedMatchId: $feedMatchId")
        Log.d(logTag, "This should give either homeTeam or awayTeam: $team")
        listOfPlayersViewModel.loadSavedMatch(feedMatchId)
        initRecyclerView()
        addDataSet(ArrayList())
        inflateUserInterface(team)

    }

    private fun inflateUserInterface(team: String) {
        listOfPlayersViewModel.currentMatch.observe(this, Observer {
            if (team == "homeTeam") {
                val listOfPlayers = listOfPlayersViewModel.currentMatch.value?.homeTeam?.players
                addDataSet(listOfPlayers!!)
                playersAdapter.notifyDataSetChanged()
            } else {
                val listOfPlayers = listOfPlayersViewModel.currentMatch.value?.awayTeam?.players
                addDataSet(listOfPlayers!!)
                playersAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun addDataSet(listOfPlayers: ArrayList<Players>) {
        Log.d(logTag, "$listOfPlayers")
        playersAdapter.submitList(listOfPlayers)
    }

    private fun initRecyclerView() {
        Log.d(logTag, "initRecyclerView() was called!")
        recycler_view_list_of_players.apply {
            layoutManager = LinearLayoutManager(context)
            val topSpacingDecoration = TopSpacingItemDecoration(20)
            addItemDecoration(topSpacingDecoration)
            playersAdapter = PlayersAdapter { player: Players -> onPlayerClicked(player) }
            adapter = playersAdapter
        }
    }

    private fun onPlayerClicked (player: Players) {
        Toast.makeText(context, "${player.firstName} was clicked!", Toast.LENGTH_SHORT).show()
    }

}
