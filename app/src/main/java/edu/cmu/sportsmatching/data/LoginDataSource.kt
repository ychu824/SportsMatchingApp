package edu.cmu.sportsmatching.data

import edu.cmu.sportsmatching.data.model.LoggedInUser
import java.io.IOException
import java.lang.Exception

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    companion object {
        private const val fakeUserName = "yhu3@andrew.cmu.edu"
        private const val fakePassword = "123456"
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            // Handle loggedInUser authentication
            if (username != fakeUserName || password != fakePassword) {
                throw Exception("Invalid username or password")
            }

            val fakeUser = LoggedInUser(
                java.util.UUID.randomUUID().toString(),
                "Yucheng Hu")
            Result.Success(fakeUser)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}