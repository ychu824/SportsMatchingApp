package edu.cmu.sportsmatching.data.model

import edu.cmu.sportsmatching.R

enum class Type {
    MATCH_INVITATION,
    FRIEND_REQUEST,
}

data class Match(
    var type: Type = Type.MATCH_INVITATION,
    val starter: String,
    val title: String? = null,
    val imageUri: Int = R.drawable.basketball_on_court,
    val location: String? = null,
    val sport: String? = null,
    val currentTeam: Int = 0,
    val totalTeam: Int = 0,
    val startTime: String? = null,
    val endTime: String? = null,
    val date: String? = null,
    val mainText: String = "",
    val participants: List<User>
)
