package com.nikola.androiddeveloperassignmentincrowdsportsii.room

import android.app.Application
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Data

class RoomRepository(application: Application) {
    private val matchDAO: MatchDAO?

    init {
        val db = MatchDatabase.getInstance(application)
        matchDAO = db?.matchDAO()
    }

    suspend fun findMatchById(feedMatchId: Int?): Data? = matchDAO?.findMatch(feedMatchId)

    suspend fun insertMatch(match: Data?) = matchDAO?.insertMatch(match)

    suspend fun deleteMatch(match: Data?) = matchDAO?.deleteMatch(match)


}