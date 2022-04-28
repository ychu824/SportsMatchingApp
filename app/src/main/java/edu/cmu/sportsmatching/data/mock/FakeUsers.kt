package edu.cmu.sportsmatching.data.mock

import edu.cmu.sportsmatching.data.model.User

object FakeUsers {
    private val user1 = User("John J", "")
    private val user2 = User("Mike M", "")
    private val user3 = User("Kyle K", "")
    private val user4 = User("David D", "")
//    private val user5 = User("")

    val users = arrayListOf(user1, user2, user3, user4)
}