package edu.cmu.sportsmatching.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), MatchInfoAdapter.OnMatchListener {

    companion object {
        private const val TAG = "HomeFragment"
    }

    private lateinit var mMatchInfoRecyclerView: RecyclerView
    private lateinit var mFilterMatchButton: ToggleButton
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        mMatchInfoRecyclerView = binding.matchInfoRecyclerView
        mFilterMatchButton = binding.filterMatchButton
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        // FIXME: Replace some mock data with real data here
        val matchInfoAdapter = MatchInfoAdapter(FakeMatches.matches, this)
        layoutManager.scrollToPositionWithOffset(0, 0)
        mMatchInfoRecyclerView.layoutManager = layoutManager
        mMatchInfoRecyclerView.adapter = matchInfoAdapter
        mFilterMatchButton.setOnCheckedChangeListener { _, isChecked ->
            // TODO: Filter matches
            if (isChecked) {
                Toast.makeText(activity, "Checked (incoming)", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Unchecked (pending)", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    override fun onMatchClick(position: Int) {
        Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show()
    }
}