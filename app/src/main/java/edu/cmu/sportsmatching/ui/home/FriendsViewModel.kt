package edu.cmu.sportsmatching.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.cmu.sportsmatching.data.model.User

class FriendsViewModel(friends: ArrayList<User>) : ViewModel() {
    private val _friends: MutableLiveData<ArrayList<User>> = MutableLiveData(friends)
    val friends: LiveData<ArrayList<User>> = _friends

    fun addFriend(friend: User) {
        this._friends.value?.add(friend)
    }
}