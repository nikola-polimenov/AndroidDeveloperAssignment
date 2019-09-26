package com.nikola.androiddeveloperassignmentincrowdsports.ui.main.fragments.matchinfo

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nikola.androiddeveloperassignmentincrowdsports.network.NetworkRepository
import com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels.Match
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MatchInfoViewModel (application: Application) : AndroidViewModel(application) {
    private val networkRepository: NetworkRepository = NetworkRepository()
    private val tag = "MatchInfoViewModel Testing:"
    var currentMatch: MutableLiveData<Match> = MutableLiveData()

    fun getMatch(feedMatchId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = networkRepository.getMatch(feedMatchId)
                if (result.isSuccessful) {
                    Log.d(tag, "If it works this log should say Manchester United: ${result.body()?.data?.homeTeam?.name}")
                    withContext(Main) {
                        currentMatch.value = result.body()
                    }
                } else {
                    Log.d(tag, result.message())
                }
            }catch (e: Exception) {
                Log.d(tag, "${e.message}")
            }
        }
    }
}