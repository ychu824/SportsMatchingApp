package edu.cmu.sportsmatching.data

import edu.cmu.sportsmatching.data.model.LoggedInUser
import java.io.IOException
import java.lang.Exception

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            // Handle loggedInUser authentication
//            if (username != fakeUserName || password != fakePassword) {
//                throw Exception("Invalid username or password")
//            }

            val fakeUser = LoggedInUser(
                java.util.UUID.randomUUID().toString(),
                "Doraemon")
            Result.Success(fakeUser)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}