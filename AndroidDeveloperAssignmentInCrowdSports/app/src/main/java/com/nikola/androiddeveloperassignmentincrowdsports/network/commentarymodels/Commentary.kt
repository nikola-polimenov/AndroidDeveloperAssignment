package com.nikola.androiddeveloperassignmentincrowdsports.network.commentarymodels

import com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels.Metadata


data class Commentary (
    var status: String?,
    var data: Data,
    var metadata: Metadata
)