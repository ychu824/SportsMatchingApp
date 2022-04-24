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
    fun remove(match : Match) : Boolean{
        if(!this._pendingMatches.value?.isEmpty()!!){
            return false
        }
        if(!this._pendingMatches.value?.contains(match)!!){
            return false
        }
        this._pendingMatches.value?.remove(match)
        return true
    }
}