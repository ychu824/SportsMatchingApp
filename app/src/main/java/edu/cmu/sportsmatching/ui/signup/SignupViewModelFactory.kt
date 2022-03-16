package edu.cmu.sportsmatching.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.cmu.sportsmatching.data.SignupRepository
import java.lang.IllegalArgumentException

class SignupViewModelFactory : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
            return SignupViewModel(SignupRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}