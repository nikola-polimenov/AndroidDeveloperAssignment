package com.nikola.androiddeveloperassignmentincrowdsports.network

import com.nikola.androiddeveloperassignmentincrowdsports.network.commentarymodels.Commentary
import com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels.Match
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://feeds.incrowdsports.com/provider/opta/football/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CommentaryApiService {

    @GET("matches/{feedMatchId}/commentary")
    suspend fun getCommentary(@Path("feedMatchId") feedMatchId: Int): Response<Commentary>

}

object CommentaryApi {
    val retrofitService: CommentaryApiService by lazy {
        retrofit.create(CommentaryApiService::class.java)
    }
}