package com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels

data class Players (
    var id: Int?,
    var firstName: String?,
    var lastName: String?,
    var position: String?,
    var shirtNumber: Int?,
    var status: String?,
    var captain: Boolean?,
    var playerStats: PlayerStats?
    )