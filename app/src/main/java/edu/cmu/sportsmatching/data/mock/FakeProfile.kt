package edu.cmu.sportsmatching.data.mock

import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.data.model.User

object FakeProfile {
    val P_name = "Doraemon"
    val P_status = "M/25/student"
    val P_sports: List<String> = listOf("Jogging", "Basketball", "Tennis", "billiard", "swimming", "football", "league of legend")
    val P_timelist: List<Int> = listOf(300, 150, 50)
    val total_time = P_timelist[0]+P_timelist[1]+P_timelist[2]
    val P_time = total_time.toString()
    val P_status_message = "Let's work out!"
}