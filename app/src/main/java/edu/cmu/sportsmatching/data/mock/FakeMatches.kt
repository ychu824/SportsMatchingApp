package edu.cmu.sportsmatching.data.mock

import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.data.model.User

object FakeMatches {
    private val fakeMatch = Match(starter = "Yizhou Liu", title = "Ping Pong double people GAME AT 4 PM PITTSBURGH!!",
        imageUri = "https://cdn.vox-cdn.com/thumbor/l3P7vpY-Onaliz9OsgUz3y2mlh0=/0x0:4022x2681/920x613/filters:focal(1627x217:2269x859):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/70624496/usa_today_17896947.0.jpg", currentTeam = 4, totalTeam = 4, location = "Pittsburgh, PA, 15217",
        sport = "Table Tennis", startTime = "16:00", endTime = "18:00", date = "March 30th", mainText = "Looking for people to join our basketball game at basketball field in CMU campus! From 4 pm to 6 pm or later! Welcome anyone who is above 18 and interested! No requirement for skills and levels!",
        participants = listOf()
    )


    private val fakeMatch_1 = Match(starter = "Yucheng Hu", title = "Ping Pong double people GAME AT 4 PM PITTSBURGH!!",
        imageUri = "https://cdn.vox-cdn.com/thumbor/l3P7vpY-Onaliz9OsgUz3y2mlh0=/0x0:4022x2681/920x613/filters:focal(1627x217:2269x859):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/70624496/usa_today_17896947.0.jpg", currentTeam = 4, totalTeam = 4, location = "Pittsburgh, PA, 15217",
        sport = "Table Tennis", startTime = "16:00", endTime = "18:00", date = "March 30th", mainText = "Looking for people to join our basketball game at basketball field in CMU campus! From 4 pm to 6 pm or later! Welcome anyone who is above 18 and interested! No requirement for skills and levels!",
        participants = listOf()
    )

    val matches: ArrayList<Match> = ArrayList()

    init {
        for (i in 0 until 3) {
            this.matches.add(fakeMatch)
            this.matches.add(fakeMatch_1)
        }
    }

    val fakeUser = User(name = "Yizhou Liu", password = "", phone = "", email = "")
    val users: ArrayList<User> = ArrayList()
    init {
        for (i in 0 until 5) {
            this.users.add(fakeUser)
        }

    }
}