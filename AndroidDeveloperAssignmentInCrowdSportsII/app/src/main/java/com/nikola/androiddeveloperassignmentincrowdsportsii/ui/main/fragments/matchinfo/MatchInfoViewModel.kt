package com.nikola.androiddeveloperassignmentincrowdsportsii.ui.main.fragments.matchinfo

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Data
import com.nikola.androiddeveloperassignmentincrowdsportsii.network.NetworkRepository
import com.nikola.androiddeveloperassignmentincrowdsportsii.room.RoomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MatchInfoViewModel (application: Application) : AndroidViewModel(application) {
    private val roomRepository: RoomRepository = RoomRepository(application)
    private val tag = "MatchInfoViewModel Testing:"
    var currentMatch: MutableLiveData<Data> = MutableLiveData()


    fun loadSavedMatch (feedMatchId: Int) {
        CoroutineScope(IO).launch {
            val result = roomRepository.findMatchById(feedMatchId)
            withContext(Main) {
                currentMatch.value = result
            }
        }
    }

}