package com.nikola.androiddeveloperassignmentincrowdsports.network

import com.nikola.androiddeveloperassignmentincrowdsports.network.commentarymodels.Commentary
import com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels.Match
import retrofit2.Response

class NetworkRepository {

    suspend fun getMatch(feedMatchId: Int):Response<Match> = MatchApi.retrofitService.getMatch(feedMatchId)

    suspend fun getCommentary(feedMatchId: Int):Response<Commentary> = CommentaryApi.retrofitService.getCommentary(feedMatchId)

}