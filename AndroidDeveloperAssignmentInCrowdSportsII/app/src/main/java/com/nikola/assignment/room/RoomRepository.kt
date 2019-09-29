package com.nikola.assignment.room

import android.app.Application
import com.nikola.assignment.models.matchmodels.Data

class RoomRepository(application: Application) {
    private val matchDAO: MatchDAO?
    private val commentaryDAO: CommentaryDAO?

    init {
        val db = MatchDatabase.getInstance(application)
        matchDAO = db?.matchDAO()
        commentaryDAO = db?.commentaryDAO()
    }

    suspend fun findMatchById(feedMatchId: Int?): Data? = matchDAO?.findMatch(feedMatchId)

    suspend fun insertMatch(match: Data?) = matchDAO?.insertMatch(match)

    suspend fun deleteMatch(match: Data?) = matchDAO?.deleteMatch(match)

    ////////////////////////////////////////////////////////////////////

    suspend fun findCommentaryById(feedMatchId: Int?): com.nikola.assignment.models.commentarymodels.Data? =
        commentaryDAO?.findCommentary(feedMatchId)

    suspend fun insertCommentary(commentary: com.nikola.assignment.models.commentarymodels.Data?) =
        commentaryDAO?.insertCommentary(commentary)

    suspend fun deleteCommentary(commentary: com.nikola.assignment.models.commentarymodels.Data?) =
        commentaryDAO?.deleteCommentary(commentary)

}