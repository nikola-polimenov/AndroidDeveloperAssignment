package com.nikola.assignment.ui.splashscreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nikola.assignment.network.NetworkRepository
import com.nikola.assignment.models.commentarymodels.Commentary
import com.nikola.assignment.models.matchmodels.Data
import com.nikola.assignment.models.matchmodels.Match
import com.nikola.assignment.room.RoomRepository
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
                        if (checkIfCommentaryAlreadyExists(currentMatchCommentary.value?.data?.feedMatchId)) {
                            saveCommentary(currentMatchCommentary.value?.data)
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

    private suspend fun checkIfCommentaryAlreadyExists(feedMatchId: Int?): Boolean {
        return withContext(IO) {
            val result = roomRepository.findCommentaryById(feedMatchId)
            return@withContext result == null
        }
    }

    private suspend fun saveCommentary(commentary: com.nikola.assignment.models.commentarymodels.Data?) {
        withContext(IO) {
            roomRepository.insertCommentary(commentary)
        }
    }
}