package edu.cmu.sportsmatching.ui.startmatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.cmu.sportsmatching.data.model.Match

class PendingMatchViewModel(private val matches : ArrayList<Match>) : ViewModel(){
    private val _pendingMatches: MutableLiveData<ArrayList<Match>> = MutableLiveData(matches)
    val pendingMatches: LiveData<ArrayList<Match>> = _pendingMatches


    /**
     *  add match from fake data
     */
    fun add(match: Match) {
        this._pendingMatches.value?.add(match)
    }

    /**
     * remove match if user click agree on 1; return true if success, false otherwise
     */
    fun remove(position: Int) : Boolean{
        val size = this._pendingMatches.value?.size
        if (position >= size!!) {
            return false
        }
        this._pendingMatches.value?.removeAt(position)
        return true
    }
}