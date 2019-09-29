package com.nikola.assignment.ui.main.fragments.listofplayers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nikola.assignment.models.matchmodels.Data
import com.nikola.assignment.room.RoomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListOfPlayersViewModel(application: Application) : AndroidViewModel(application) {
    private val roomRepository: RoomRepository = RoomRepository(application)
    //private val tag = "MatchInfoViewModel Testing:"
    var currentMatch: MutableLiveData<Data> = MutableLiveData()


    fun loadSavedMatch (feedMatchId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = roomRepository.findMatchById(feedMatchId)
            withContext(Dispatchers.Main) {
                currentMatch.value = result
            }
        }
    }
}
