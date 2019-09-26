package com.nikola.androiddeveloperassignmentincrowdsports.ui.splashscreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nikola.androiddeveloperassignmentincrowdsports.network.NetworkRepository
import com.nikola.androiddeveloperassignmentincrowdsports.network.commentarymodels.Commentary
import com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels.Match
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class SplashScreenViewModel(application: Application): AndroidViewModel(application) {
    private val networkRepository: NetworkRepository = NetworkRepository()
    private val tag = "SplashScreenViewModel Testing:"
    var currentMatch: MutableLiveData<Match> = MutableLiveData()
    var currentMatchCommentary: MutableLiveData<Commentary> = MutableLiveData()

    fun getMatch(feedMatchId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = networkRepository.getMatch(feedMatchId)
                if (result.isSuccessful) {
                    Log.d(tag, "If it works this log should say Manchester United: ${result.body()?.data?.homeTeam?.name}")
                    withContext(Dispatchers.Main) {
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

    fun getCommentary(feedMatchId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = networkRepository.getCommentary(feedMatchId)
                if (result.isSuccessful) {
                    Log.d(tag, "If it works this log should say Manchester United: ${result.body()?.data?.homeTeamName}")
                    withContext(Dispatchers.Main) {
                        currentMatchCommentary.value = result.body()
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