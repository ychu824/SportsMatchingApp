package edu.cmu.sportsmatching.data.model

data class Match(
    val starter: String? = null,
    val title: String? = null,
    val imageUri: String? = null,
    val location: String? = null,
    val sport: String? = null,
    val currentTeam: Int = 0,
    val totalTeam: Int = 0,
    val startTime: String? = null,
    val endTime: String? = null,
    val date: String? = null,
)
