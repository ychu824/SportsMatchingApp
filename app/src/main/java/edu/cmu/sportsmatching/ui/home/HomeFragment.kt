package edu.cmu.sportsmatching.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.databinding.FragmentHomeBinding
import edu.cmu.sportsmatching.ui.signup.SignupFragment

class HomeFragment : Fragment(), MatchInfoAdapter.OnMatchListener {

    companion object {
        private const val TAG = "HomeFragment"
    }

    private lateinit var mMatchInfoRecyclerView: RecyclerView
    private lateinit var mMatchAdapter: MatchInfoAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        mMatchInfoRecyclerView = binding.matchInfoRecyclerView
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        // FIXME: Replace some mock data with real data here
        this.mMatchAdapter = MatchInfoAdapter(FakeMatches.matches, this)
        layoutManager.scrollToPositionWithOffset(0, 0)
        mMatchInfoRecyclerView.layoutManager = layoutManager
        mMatchInfoRecyclerView.adapter = this.mMatchAdapter
        return binding.root
    }

    override fun onMatchClick(position: Int) {
        val fragmentManager: FragmentManager? = activity?.supportFragmentManager
        if (fragmentManager != null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.replace(R.id.main_fragment_container, DetailPageFragment(
                this.mMatchAdapter.matches[position]))
            transaction.commit()
            transaction.addToBackStack(null)
        }
    }
}