package com.nikola.androiddeveloperassignmentincrowdsportsii.ui.main.fragments.matchinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.nikola.androiddeveloperassignmentincrowdsportsii.R
import com.nikola.androiddeveloperassignmentincrowdsportsii.utils.Constants
import kotlinx.android.synthetic.main.fragment_match_info.*


class MatchInfoFragment: Fragment() {
    private lateinit var matchInfoViewModel: MatchInfoViewModel
    private val constants: Constants = Constants()
    //private val logTag = "MatchInfoFragment: Testing"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        matchInfoViewModel = ViewModelProviders.of(this).get(MatchInfoViewModel::class.java)
        return inflater.inflate(R.layout.fragment_match_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchInfoViewModel.loadSavedMatch(constants.feedMatchId)
        inflateUserInterface()

        cardView_home_team.setOnClickListener {
            onClickHomeTeam()
        }

        cardView_away_team.setOnClickListener {
            onClickAwayTeam()
        }

    }

    private fun onClickHomeTeam() {

    }

    private fun onClickAwayTeam() {

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