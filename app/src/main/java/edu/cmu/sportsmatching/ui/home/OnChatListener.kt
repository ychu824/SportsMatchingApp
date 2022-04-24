package edu.cmu.sportsmatching.ui.home

import androidx.fragment.app.FragmentManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.User

class OnChatListener(private val fragmentManager: FragmentManager, private val data: User) {
    fun onChatClick() {
        val transaction = fragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.replace(
            R.id.main_fragment_container, ChatPageFragment(
            data))
        transaction.commit()
        transaction.addToBackStack(null)
    }
}