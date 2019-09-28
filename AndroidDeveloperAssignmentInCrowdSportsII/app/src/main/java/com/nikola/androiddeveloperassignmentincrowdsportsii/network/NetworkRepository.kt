package com.nikola.androiddeveloperassignmentincrowdsportsii.network

import com.nikola.androiddeveloperassignmentincrowdsportsii.models.commentarymodels.Commentary
import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Match
import retrofit2.Response

class NetworkRepository {

    suspend fun getMatch(feedMatchId: Int):Response<Match> = MatchApi.retrofitService.getMatch(feedMatchId)

    suspend fun getCommentary(feedMatchId: Int):Response<Commentary> = CommentaryApi.retrofitService.getCommentary(feedMatchId)

}