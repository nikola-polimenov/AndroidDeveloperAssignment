package com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels

data class AwayTeam (
    var id: String?,
    var name: String?,
    var shortName: String?,
    var score: Int?,
    var halfTimeScore: Int?,
    var players: ArrayList<Players>?,
    var teamStats: TeamStats?,
    var imageUrl: String?
)