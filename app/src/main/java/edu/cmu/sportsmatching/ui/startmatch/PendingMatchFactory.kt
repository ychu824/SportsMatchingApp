package edu.cmu.sportsmatching.ui.startmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.ui.signup.SignupViewModel
import java.lang.IllegalArgumentException



class PendingMatchFactory : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PendingMatchViewModel::class.java)) {
            return PendingMatchViewModel(FakeMatches.matches) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}