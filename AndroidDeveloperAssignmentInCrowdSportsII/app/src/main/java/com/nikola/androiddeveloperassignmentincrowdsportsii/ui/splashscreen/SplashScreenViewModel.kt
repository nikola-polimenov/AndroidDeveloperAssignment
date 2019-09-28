package com.nikola.androiddeveloperassignmentincrowdsportsii.ui.splashscreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nikola.androiddeveloperassignmentincrowdsportsii.network.NetworkRepository
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.commentarymodels.Commentary
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Data
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Match
import com.nikola.androiddeveloperassignmentincrowdsportsii.room.RoomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class SplashScreenViewModel(application: Application): AndroidViewModel(application) {
    private val networkRepository: NetworkRepository = NetworkRepository()
    private val roomRepository: RoomRepository = RoomRepository(application)
    private val tag = "SplashScreenViewModel Testing:"
    private var currentMatch: MutableLiveData<Match> = MutableLiveData()
    private var currentMatchCommentary: MutableLiveData<Commentary> = MutableLiveData()

    fun getMatch(feedMatchId: Int) {
        CoroutineScope(IO).launch {
            try {
                val result = networkRepository.getMatch(feedMatchId)
                if (result.isSuccessful) {
                    Log.d(tag, "If it works this log should say Manchester United: ${result.body()?.data?.homeTeam?.name}")
                    Log.d(tag, "If it works this log should say kick off: ${result.body()?.data?.events?.get(0)?.type}")
                    Log.d(tag, "If it works this log should say Scott Ledger: ${result.body()?.data?.officials?.get(0)?.name}")
                    withContext(Dispatchers.Main) {
                        currentMatch.value = result.body()
                        if (checkIfMatchAlreadyExists(currentMatch.value?.data?.feedMatchId)) {
                            saveMatch(currentMatch.value?.data)
                        }
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
        CoroutineScope(IO).launch {
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

    private suspend fun checkIfMatchAlreadyExists(feedMatchId: Int?): Boolean {
        return withContext(IO) {
            val result = roomRepository.findMatchById(feedMatchId)
            return@withContext result == null
        }
    }

    private suspend fun saveMatch(match: Data?) {
        withContext(IO) {
            roomRepository.insertMatch(match)
        }
    }

}