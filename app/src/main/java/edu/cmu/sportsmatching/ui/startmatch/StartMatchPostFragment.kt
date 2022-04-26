package edu.cmu.sportsmatching.ui.startmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.databinding.FragmentStartmatchBinding
import edu.cmu.sportsmatching.databinding.FragmentStartmatchpostBinding

class StartMatchPostFragment(var archiveMatchViewModel: ArchiveMatchViewModel) : Fragment(){
    private lateinit var binding: FragmentStartmatchpostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStartmatchpostBinding.inflate(layoutInflater)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_startmatchpost, container, false)
        return v
    }
}