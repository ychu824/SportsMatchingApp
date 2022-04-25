package edu.cmu.sportsmatching.ui.startmatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.cmu.sportsmatching.data.model.Match

class ArchiveMatchViewModel() : ViewModel() {
    private val _archiveMatches: MutableLiveData<ArrayList<Match>> = MutableLiveData(ArrayList())
    val archiveMatches: LiveData<ArrayList<Match>> = _archiveMatches

    /**
     * add match from self-created match in 3 and self-approved match in 1
     */
    fun add(match: Match) {
        this._archiveMatches.value?.add(match)
    }
}