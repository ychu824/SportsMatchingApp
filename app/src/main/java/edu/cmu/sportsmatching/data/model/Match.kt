package edu.cmu.sportsmatching.data.model
enum class Type {
    MATCH_INVITATION,
    FRIEND_REQUEST,
}

data class Match(
    var type: Type = Type.MATCH_INVITATION,
    val starter: String,
    val title: String? = null,
    val imageUri: String? = null,
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
