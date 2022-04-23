package edu.cmu.sportsmatching.ui.startmatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.cmu.sportsmatching.data.model.Match

class ArchiveMatchViewModel(private val matches: ArrayList<Match>) : ViewModel() {
    private val _archiveMatches: MutableLiveData<ArrayList<Match>> = MutableLiveData(matches)
    val archiveMatches: LiveData<ArrayList<Match>> = _archiveMatches

    fun add(match: Match) {
        this._archiveMatches.value?.add(match)
    }



}