package edu.cmu.sportsmatching.ui.startmatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StartMatchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StartMatchViewModel::class.java)) {
            //if we want matches initally, set it to fakematches
            return StartMatchViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
