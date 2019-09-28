package com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels

data class PlayerStats (
    var bottomRightGoals: Int?,
    var bottomRightSaves: Int?,
    var bottomLeftGoals: Int?,
    var bottomLeftSaves: Int?,
    var bottomCentreGoals: Int?,
    var bottomCentreSaves: Int?,

    var centreBoxShots: Int?,
    var concededShotsOnTargetInsideBox: Int?,
    var concededShotsOnTargetOutsideBox: Int?,
    var cornersTaken: Int?,
    var cornersLost: Int?,
    var cornersWon: Int?,

    var directFreeKicks: Int?,
    var defenderBlocks: Int?,

    var formationPlace: Int?,
    var finalThirdFouls: Int?,
    var freeKickCrosses: Int?,

    var goalAssists: Int?,
    var goalsConceded: Int?,
    var goalsConcededInsideBox: Int?,
    var goals: Int?,
    var goalKicks: Int?,

    var headerGoals: Int?,
    var headerShots: Int?,
    var headerMisses: Int?,
    var handBalls: Int?,

    var intentionalGoalAssists: Int?,
    var insideBoxBlocks: Int?,
    var insideBoxGoals: Int?,
    var insideBoxGoalkeeperSaves: Int?,
    var insideBoxSaves: Int?,
    var insideBoxMisses: Int?,

    var keeperDivingSaves: Int?,

    var leftBoxShots: Int?,
    var leftFootShotSaves: Int?,
    var leftFootShotGoals: Int?,
    var leftFootShots: Int?,
    var leftMisses: Int?,

    var minutesPlayed: Int?,

    var numberOfFouls: Int?,

    var openPlayGoals: Int?,
    var openPlayGoalAssists: Int?,
    var openPlayShots: Int?,
    var outsideBoxGoalkeeperSaves: Int?,
    var outsideBoxBlocks: Int?,
    var outsideBoxSaves: Int?,
    var outsideBoxMisses: Int?,
    var outsideBoxCentreShots: Int?,

    var penaltyGoals: Int?,
    var penaltyGoalsConceded: Int?,
    var penaltiesFaced: Int?,

    var throwIns: Int?,
    var totalCornersIntoBox: Int?,
    var topRightGoals: Int?,
    var topLeftGoals: Int?,
    var topMisses: Int?,

    var rightFootSaves: Int?,
    var rightFootShots: Int?,
    var rightFootGoals: Int?,
    var rightMisses: Int?,

    var shotsOnTarget: Int?,
    var shotsOnTargetAssists: Int?,
    var shotsOffTarget: Int?,
    var shotsOnGoal: Int?,
    var shotsBlocked: Int?,
    var started: Int?,
    var subsOn: Int?,
    var subsOff: Int?,
    var saves: Int?,

    var yellowCards: Int?,

    var woodworkHits: Int?
)
