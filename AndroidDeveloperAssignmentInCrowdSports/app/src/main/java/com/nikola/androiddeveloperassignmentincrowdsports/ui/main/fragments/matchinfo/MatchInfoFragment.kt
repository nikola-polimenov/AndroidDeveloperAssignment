package com.nikola.androiddeveloperassignmentincrowdsports.ui.main.fragments.matchinfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.nikola.androiddeveloperassignmentincrowdsports.R
import com.nikola.androiddeveloperassignmentincrowdsports.utils.Constants
import kotlinx.android.synthetic.main.fragment_match_info.*

class MatchInfoFragment: Fragment() {
    private lateinit var matchInfoViewModel: MatchInfoViewModel
    private val constants:Constants = Constants()
    private val TAG = "MatchInfoFragment: Testing"

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
        matchInfoViewModel.getMatch(constants.feedMatchId)

        matchInfoViewModel.currentMatch.observe(this, Observer {

            Log.d(TAG, "${matchInfoViewModel.currentMatch.value?.data?.homeTeam?.imageUrl}")
            Glide.with(home_team_image).load(matchInfoViewModel.currentMatch.value?.data?.homeTeam?.imageUrl).into(home_team_image)

            Log.d(TAG, "${matchInfoViewModel.currentMatch.value?.data?.awayTeam?.imageUrl}")
            Glide.with(away_team_image).load(matchInfoViewModel.currentMatch.value?.data?.awayTeam?.imageUrl).into(away_team_image)

        })

    }
}