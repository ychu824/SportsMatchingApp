package edu.cmu.sportsmatching.ui.startmatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.ui.login.LoginFormState
import java.util.regex.Matcher
import java.util.regex.Pattern

class StartMatchViewModel() : ViewModel() {
    private val _startMatchState = MutableLiveData<StartMatchState>()
    val startMatchState: LiveData<StartMatchState> = _startMatchState


    private fun isTimeValid(startTime: String, endTime: String): Boolean {
        val regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]"
        val p: Pattern = Pattern.compile(regex)
        if (startTime == null || endTime == null) {
            return false
        }

        //validate corrent time
        val m_start: Matcher = p.matcher(startTime)
        if (m_start.matches() == false) {
            return false
        }
        val m_end: Matcher = p.matcher(endTime)
        if (m_end.matches() == false) {
            return false
        }

        // TODO: check start time precede to end time


        return true

    }

    private fun isTeammateNumValid(num: String): Boolean {
        val parsedInt: Int
        try {
            parsedInt = num.toInt()
        } catch (nfe: NumberFormatException) {
            // not a valid int
            return false
        }
        return parsedInt >= 1
    }

    fun startMatchDataChanged(startTime: String, endTime: String, num: String) {
        if (!isTimeValid(startTime, endTime)) {
            _startMatchState.value = StartMatchState(startTimeError = "Incorrect time format!")
        } else if (!isTeammateNumValid(num)) {
            _startMatchState.value =
                StartMatchState(teammatesNumError = "Incorrect teammate number")
        } else {
            _startMatchState.value = StartMatchState(isContinueValid = true)
        }
    }


}