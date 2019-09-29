package com.nikola.assignment.models.commentarymodels

import com.nikola.assignment.models.matchmodels.Metadata


data class Commentary (
    var status: String?,
    var data: Data,
    var metadata: Metadata
)