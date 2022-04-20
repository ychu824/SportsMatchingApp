package edu.cmu.sportsmatching.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class Event(
    val location: String,
    val start_time: String,
    val end_time: String,
    val ocur_spots: Int,
    val all_spots: Int,
    val sport_type: String,
    val date: String,
)