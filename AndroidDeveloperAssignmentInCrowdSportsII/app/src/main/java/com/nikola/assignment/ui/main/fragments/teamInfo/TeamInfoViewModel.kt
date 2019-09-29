package com.nikola.assignment.ui.main.fragments.teamInfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nikola.assignment.models.matchmodels.Data
import com.nikola.assignment.room.RoomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamInfoViewModel (application: Application) : AndroidViewModel(application) {
    private val roomRepository: RoomRepository = RoomRepository(application)
    private val tag = "TeamInfoViewModel Testing:"
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