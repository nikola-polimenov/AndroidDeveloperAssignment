package com.nikola.assignment.ui.main.fragments.teamInfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.nikola.assignment.R
import com.nikola.assignment.utils.TopSpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_team_info.*

class TeamInfoFragment : Fragment() {
    private lateinit var teamInfoViewModel: TeamInfoViewModel
    private lateinit var teamStatsAdapter: TeamStatsAdapter
    private val logTag = "TeamInfoFragment Testing:"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        teamInfoViewModel = ViewModelProviders.of(this).get(TeamInfoViewModel::class.java)
        return inflater.inflate(R.layout.fragment_team_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val feedMatchId = arguments?.get("feedMatchId") as Int
        val team = arguments?.get("team").toString()
        Log.d(logTag, "If this works it should say 987597 $feedMatchId")
        Log.d(logTag, "If this works it should say either homeTeam or awayTeam:$team")
        teamInfoViewModel.loadSavedMatch(feedMatchId)
        initRecyclerView()
        addDataSet(ArrayList())
        inflateUserInterface(team)

        button_list_of_players.setOnClickListener {
            onClickListOfPlayers(it, team)
        }

        Toast.makeText(
            context,
            "Hint: Click on one of the 'Show List of players' button.",
            Toast.LENGTH_SHORT
        ).show()


    }

    private fun inflateUserInterface(team: String) {
        teamInfoViewModel.currentMatch.observe(this, Observer {
            val currentMatch = it
            if (team == "homeTeam") {
                Glide.with(team_info_image).load(currentMatch.homeTeam?.imageUrl)
                    .into(team_info_image)
                val homeTeamName =
                    "${currentMatch.homeTeam?.name} (${currentMatch.homeTeam?.shortName})"
                team_info_name.text = homeTeamName
                val homeTeamScore = "Score: ${currentMatch.homeTeam?.score}"
                team_info_score.text = homeTeamScore
                val homeTeamHalftimeScore = "HalftimeScore: ${currentMatch.homeTeam?.halfTimeScore}"
                team_info_halftime_score.text = homeTeamHalftimeScore
                val homeTeamStats = iterateThroughTeamStats(currentMatch.homeTeam?.teamStats.toString())
                addDataSet(homeTeamStats)
                teamStatsAdapter.notifyDataSetChanged()
            } else {
                Glide.with(team_info_image).load(currentMatch.awayTeam?.imageUrl)
                    .into(team_info_image)
                val awayTeamName =
                    "${currentMatch.awayTeam?.name} (${currentMatch.awayTeam?.shortName})"
                team_info_name.text = awayTeamName
                val awayTeamScore = "Score: ${currentMatch.awayTeam?.score}"
                team_info_score.text = awayTeamScore
                val awayTeamHalftimeScore = "HalftimeScore: ${currentMatch.awayTeam?.halfTimeScore}"
                team_info_halftime_score.text = awayTeamHalftimeScore
                val awayTeamStats = iterateThroughTeamStats(currentMatch.awayTeam?.teamStats.toString())
                addDataSet(awayTeamStats)
                teamStatsAdapter.notifyDataSetChanged()
            }

        })
    }

    private fun onClickListOfPlayers(view: View, team: String) {
        view.let {
            findNavController().navigate(
                R.id.action_teamInfoFragment_to_listOfPlayersFragment,
                bundleOf("team" to team)
            )
        }
    }

    private fun addDataSet(listOfTeamStats: ArrayList<String>) {
        Log.d(logTag, "$listOfTeamStats")
        teamStatsAdapter.submitList(listOfTeamStats)
    }

    private fun initRecyclerView() {
        Log.d(logTag, "initRecyclerView() was called!")
        recycler_view_list_of_team_stats.apply {
            layoutManager = LinearLayoutManager(context)
            val topSpacingDecoration = TopSpacingItemDecoration(20)
            addItemDecoration(topSpacingDecoration)
            teamStatsAdapter = TeamStatsAdapter()
            adapter = teamStatsAdapter
        }
    }

    private fun iterateThroughTeamStats(teamStats: String?): ArrayList<String> {
        // This method is completely insane, but i am just trying something out.
        var counter = 0
        val arrayTeamStats = teamStats?.replace("TeamStats(", " ")
            ?.replace(")", "")
            ?.split(",")
        val finalArrayTeamStats: MutableList<String> = ArrayList()
        arrayTeamStats?.forEach {
            counter++
            if (!it.contains("0")) {
                finalArrayTeamStats.add(it)
            }
        }
        return finalArrayTeamStats as ArrayList<String>
    }
}