package edu.cmu.sportsmatching.ui.startmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.cmu.sportsmatching.data.SignupRepository
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.ui.signup.SignupViewModel
import java.lang.IllegalArgumentException

class ArchiveMatchFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArchiveMatchViewModel::class.java)) {
            //if we want matches initially, set it to fakematches
            return ArchiveMatchViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



