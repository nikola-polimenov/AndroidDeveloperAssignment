package com.nikola.assignment.models.matchmodels



data class Players (
    var id: Int?,
    var firstName: String?,
    var lastName: String?,
    var position: String?,
    var shirtNumber: Int?,
    var status: String?,
    var captain: Boolean?,
    var playerStats: PlayerStats?
    ) {

    /*
    override fun equals(other: Any?): Boolean {
        if (javaClass != other?.javaClass) {
            return false
        }

        other as Players

        if (id != other.id) {
            return false
        }
        if (firstName != other.firstName) {
            return false
        }
        if (lastName != other.lastName) {
            return false
        }
        if (position != other.position) {
            return false
        }
        if (shirtNumber != other.shirtNumber) {
            return false
        }
        if (status != other.status) {
            return false
        }
        if (captain != other.captain) {
            return false
        }

        return true
    }
     */

}
