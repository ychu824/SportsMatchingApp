package edu.cmu.sportsmatching.ui.startmatch

data class StartMatchState(
    val startTimeError: String? = null,
    val endTimeError: Int? = null,
    val teammatesNumError : String? = null,
    val isContinueValid : Boolean = false
)




