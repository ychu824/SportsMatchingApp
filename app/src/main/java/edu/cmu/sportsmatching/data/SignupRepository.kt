package edu.cmu.sportsmatching.data

import edu.cmu.sportsmatching.ui.login.LoggedInUserView

class SignupRepository {
    fun register(name: String, email: String, password: String, phone: String) : Result<LoggedInUserView> {
        return Result.Success(LoggedInUserView(name))
    }
}