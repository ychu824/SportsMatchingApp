package edu.cmu.sportsmatching.ui.home

import androidx.fragment.app.FragmentManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.User
import edu.cmu.sportsmatching.ui.startmatch.ArchiveMatchViewModel
import edu.cmu.sportsmatching.ui.startmatch.PendingMatchViewModel

class OnCheckOutListener(private val fragmentManager: FragmentManager, private val pendingMatchViewModel: PendingMatchViewModel,
                         private val archiveMatchViewModel: ArchiveMatchViewModel,
                         private val friendsViewModel: FriendsViewModel) {
    fun onChatClick() {
        val transaction = fragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.replace(
            R.id.main_fragment_container, RateHomeFragment(pendingMatchViewModel, archiveMatchViewModel,
            friendsViewModel))
        transaction.commit()
        transaction.addToBackStack(null)
    }
}