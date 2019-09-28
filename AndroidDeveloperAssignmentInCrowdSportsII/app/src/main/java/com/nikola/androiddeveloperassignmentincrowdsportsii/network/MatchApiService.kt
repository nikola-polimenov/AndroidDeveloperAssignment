package com.nikola.androiddeveloperassignmentincrowdsportsii.network

import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Match
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://feeds.incrowdsports.com/provider/opta/football/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MatchApiService {

    @GET("matches/{feedMatchId}")
    suspend fun getMatch(@Path("feedMatchId") feedMatchId: Int): Response<Match>

}

object MatchApi {
    val retrofitService: MatchApiService by lazy {
        retrofit.create(MatchApiService::class.java)
    }
}