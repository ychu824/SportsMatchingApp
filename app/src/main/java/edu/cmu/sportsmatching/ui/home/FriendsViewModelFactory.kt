package edu.cmu.sportsmatching.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.cmu.sportsmatching.data.mock.FakeUsers
import java.lang.IllegalArgumentException

class FriendsViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FriendsViewModel::class.java)) {
            return FriendsViewModel(FakeUsers.users) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}