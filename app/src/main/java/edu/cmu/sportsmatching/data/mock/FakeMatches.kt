package edu.cmu.sportsmatching.data.mock

import edu.cmu.sportsmatching.data.model.Event
import edu.cmu.sportsmatching.data.model.Match

object FakeMatches {
    private val fakeMatch = Match(starter = "Yizhou Liu", title = "Ping Pong double people GAME AT 4 PM PITTSBURGH!!",
        imageUri = "https://cdn.vox-cdn.com/thumbor/l3P7vpY-Onaliz9OsgUz3y2mlh0=/0x0:4022x2681/920x613/filters:focal(1627x217:2269x859):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/70624496/usa_today_17896947.0.jpg", currentTeam = 4, totalTeam = 4, location = "Pittsburgh, PA, 15217",
        sport = "Table Tennis", startTime = "16:00", endTime = "18:00", date = "March 30th"
    )

    val matches: ArrayList<Match> = ArrayList()

    init {
        for (i in 0 until 5) {
            this.matches.add(fakeMatch)
        }
    }

    val events: List<Event> = listOf(
        Event(location = "Pittsburgh, PA, 15219", sport_type = "Basketball",start_time = "16:00", end_time = "18:00",
            ocur_spots = 7, all_spots = 10, date = "Today")
    )
}