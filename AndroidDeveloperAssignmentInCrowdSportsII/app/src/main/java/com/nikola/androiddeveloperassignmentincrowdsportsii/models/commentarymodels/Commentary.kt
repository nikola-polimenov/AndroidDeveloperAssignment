package com.nikola.androiddeveloperassignmentincrowdsportsii.models.commentarymodels

import com.nikola.androiddeveloperassignmentincrowdsportsii.models.matchmodels.Metadata


data class Commentary (
    var status: String?,
    var data: Data,
    var metadata: Metadata
)