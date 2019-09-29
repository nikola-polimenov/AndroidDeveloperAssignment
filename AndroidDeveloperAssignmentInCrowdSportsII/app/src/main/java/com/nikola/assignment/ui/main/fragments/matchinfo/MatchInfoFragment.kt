package com.nikola.assignment.ui.main.fragments.matchinfo

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
import com.bumptech.glide.Glide
import com.nikola.assignment.R
import kotlinx.android.synthetic.main.fragment_match_info.*


class MatchInfoFragment: Fragment() {
    private lateinit var matchInfoViewModel: MatchInfoViewModel
    private var feedMatchId: Int = 0
    private val logTag = "MatchInfoFragment: Testing"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        feedMatchId = activity?.intent?.extras?.get("feedMatchId") as Int
        matchInfoViewModel = ViewModelProviders.of(this).get(MatchInfoViewModel::class.java)
        return inflater.inflate(R.layout.fragment_match_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchInfoViewModel.loadSavedMatch(feedMatchId)
        inflateUserInterface()

        Log.d(logTag, "If the Intent data transfer was successful, this should say 987597: $feedMatchId")

        cardView_home_team.setOnClickListener {
            onClickHomeTeam(cardView_home_team)
        }

        cardView_away_team.setOnClickListener {
            onClickAwayTeam(cardView_away_team)
        }

        Toast.makeText(context, "Hint: Click on one of the images.", Toast.LENGTH_SHORT).show()
    }

    private fun onClickHomeTeam(view: View) {
        view.let {
            findNavController().navigate(R.id.action_matchInfoFragment_to_teamInfoFragment, bundleOf("team" to "homeTeam", "feedMatchId" to feedMatchId))
        }
    }

    private fun onClickAwayTeam(view: View) {
        view.let {
            findNavController().navigate(R.id.action_matchInfoFragment_to_teamInfoFragment, bundleOf("team" to "awayTeam", "feedMatchId" to feedMatchId))
        }
    }

    private fun inflateUserInterface() {
        matchInfoViewModel.currentMatch.observe(this, Observer {
            home_team_name.text = matchInfoViewModel.currentMatch.value?.homeTeam?.name
            Glide.with(home_team_image).load(matchInfoViewModel.currentMatch.value?.homeTeam?.imageUrl).into(home_team_image)

            away_team_name.text = matchInfoViewModel.currentMatch.value?.awayTeam?.name
            Glide.with(away_team_image).load(matchInfoViewModel.currentMatch.value?.awayTeam?.imageUrl).into(away_team_image)
        })
    }

}