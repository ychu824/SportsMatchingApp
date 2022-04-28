package edu.cmu.sportsmatching.data.mock

import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.data.model.Type
import edu.cmu.sportsmatching.data.model.User

object FakeMatches {
    private val fakeMatch = Match(
        starter = "Yizhou Liu",
        title = "Basketball 5v5 game in CMU tonight!",
        imageUri = R.drawable.basketball_on_court,
        currentTeam = 6,
        totalTeam = 10,
        location = "Pittsburgh, PA, 15217",
        sport = "Basketball",
        startTime = "16:00",
        endTime = "18:00",
        date = "March 30th",
        mainText = "Looking for people to join our basketball game at basketball field in CMU campus! From 4 pm to 6 pm or later! Welcome anyone who is above 18 and interested! No requirement for skills and levels!",
        participants = listOf(),
        type = Type.MATCH_INVITATION
    )

    private val fakeRequest = Match(
        starter = "Yinghan Wang",
        title = "Ping Pong double people GAME AT 4 PM PITTSBURGH!!",
        imageUri = R.drawable.table_tennis,
        currentTeam = 4,
        totalTeam = 4,
        location = "Pittsburgh, PA, 15217",
        sport = "Table Tennis",
        startTime = "16:00",
        endTime = "18:00",
        date = "March 30th",
        mainText = "Looking for people to join our basketball game at basketball field in CMU campus! From 4 pm to 6 pm or later! Welcome anyone who is above 18 and interested! No requirement for skills and levels!",
        participants = listOf(),
        type = Type.FRIEND_REQUEST
    )

    private val fakeMatch_1 = Match(
        starter = "Justin Bieber",
        title = "Baseball catch and throw at CMU this afternoon",
        imageUri = R.drawable.baseball,
        currentTeam = 3,
        totalTeam = 5,
        location = "Pittsburgh, PA, 15217",
        sport = "Baseball",
        startTime = "12:00",
        endTime = "14:00",
        date = "March 30th",
        mainText = "Planning to play catch and throw with my son, welcomes anyone who want to join!",
        participants = listOf(),
        type = Type.MATCH_INVITATION
    )

    private val fakeMatch_2 = Match(
        starter = "Yinghan Wang",
        title = "Let's play tennis and stay healthy!",
        imageUri = R.drawable.tennis,
        currentTeam = 1,
        totalTeam = 2,
        location = "Pittsburgh, PA, 15217",
        sport = "Tennis",
        startTime = "13:00",
        endTime = "15:00",
        date = "March 31th",
        mainText = "Researches show that playing Tennis is good for both mental and physical healthy. We will provide equipments, bringing your own equipment is also welcomed.",
        participants = listOf(),
        type = Type.MATCH_INVITATION
    )

    private val fakeMatch_3 = Match(
        starter = "Jimmy Butler",
        title = "Looking for pro soccer players",
        imageUri = R.drawable.soccer,
        currentTeam = 2,
        totalTeam = 6,
        location = "Pittsburgh, PA, 15217",
        sport = "Basketball",
        startTime = "17:00",
        endTime = "19:00",
        date = "March 31th",
        mainText = "Hi, I'm preparing for the 2023 NBA draft, looking for strong players to train with me! Let's progress together!!",
        participants = listOf(),
        type = Type.MATCH_INVITATION
    )
    private val fakeMatch_4 = Match(
        starter = "Yizhen Wu",
        title = "Looking for expert badminton players",
        imageUri = R.drawable.badminton,
        currentTeam = 2,
        totalTeam = 6,
        location = "Pittsburgh, PA, 15217",
        sport = "Basketball",
        startTime = "17:00",
        endTime = "19:00",
        date = "March 31th",
        mainText = "Hi, I'm preparing for the 2023 NBA draft, looking for strong players to train with me! Let's progress together!!",
        participants = listOf(),
        type = Type.MATCH_INVITATION
    )
    private val fakeMatch_5 = Match(
        starter = "Yizhen Wu",
        title = "Looking for chess players",
        imageUri = R.drawable.chess,
        currentTeam = 2,
        totalTeam = 6,
        location = "Pittsburgh, PA, 15217",
        sport = "Basketball",
        startTime = "17:00",
        endTime = "19:00",
        date = "March 31th",
        mainText = "Hi, I'm preparing for the 2023 NBA draft, looking for strong players to train with me! Let's progress together!!",
        participants = listOf(),
        type = Type.MATCH_INVITATION
    )


    val matches: ArrayList<Match> = ArrayList()

    init {
        this.matches.add(fakeRequest)
        this.matches.add(fakeMatch)
        this.matches.add(fakeMatch_1)
        this.matches.add(fakeMatch_2)
        this.matches.add(fakeMatch_3)
        this.matches.add(fakeMatch_4)
        this.matches.add(fakeMatch_5)

    }

    val fakeUser = User(name = "Yizhou Liu", password = "", phone = "", email = "")
    val users: ArrayList<User> = ArrayList()

    init {
        for (i in 0 until 5) {
            this.users.add(fakeUser)
        }
    }

    var checked = false
}