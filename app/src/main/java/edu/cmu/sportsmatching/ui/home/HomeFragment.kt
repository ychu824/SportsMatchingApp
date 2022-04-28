package edu.cmu.sportsmatching.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.data.model.Type
import edu.cmu.sportsmatching.data.model.User
import edu.cmu.sportsmatching.databinding.FragmentHomeBinding
import edu.cmu.sportsmatching.databinding.NextMatchInfoBinding
import edu.cmu.sportsmatching.databinding.RateMatchInfoBinding
import edu.cmu.sportsmatching.ui.login.LoginViewModel
import edu.cmu.sportsmatching.ui.startmatch.ArchiveMatchFactory
import edu.cmu.sportsmatching.ui.startmatch.ArchiveMatchViewModel
import edu.cmu.sportsmatching.ui.startmatch.PendingMatchFactory
import edu.cmu.sportsmatching.ui.startmatch.PendingMatchViewModel

class HomeFragment(
    private val pendingMatchViewModel: PendingMatchViewModel,
    private val archiveMatchViewModel: ArchiveMatchViewModel,
    private val friendsViewModel: FriendsViewModel
) : Fragment(), MatchInfoAdapter.OnMatchListener,
    MatchInfoAdapter.ArchiveMatchesHandler,
    MatchInfoAdapter.PendingMatchesHandler,
    NextMatchFragment.CheckInHandler {

    private lateinit var mMatchInfoRecyclerView: RecyclerView
    private lateinit var mMatchAdapter: MatchInfoAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        mMatchInfoRecyclerView = binding.matchInfoRecyclerView
    }

    companion object {
        private const val TAG = "HomeFragment"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        this.mMatchAdapter =
            MatchInfoAdapter(this.pendingMatchViewModel.pendingMatches.value!!, this, this, this)
        mMatchInfoRecyclerView.layoutManager = layoutManager
        mMatchInfoRecyclerView.adapter = this.mMatchAdapter

        val fragmentManager: FragmentManager? = activity?.supportFragmentManager
        if (fragmentManager != null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            if (!FakeMatches.checked) {
                transaction.replace(
                    R.id.next_match, NextMatchFragment(this)
                )
            } else {
                transaction.replace(
                    R.id.next_match, RateMatchFragment()
                )
            }
            transaction.commit()
        }
        return binding.root
    }

    override fun onMatchClick(position: Int) {
        val fragmentManager: FragmentManager? = activity?.supportFragmentManager
        if (fragmentManager != null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.replace(
                R.id.main_fragment_container, DetailPageFragment(
                    this.mMatchAdapter.matches[position]
                )
            )
            transaction.commit()
            transaction.addToBackStack(null)
        }
    }

    override fun add(match: Match) {
        if (match.type == Type.MATCH_INVITATION) {
            this.archiveMatchViewModel.add(match) //size++
        }
        this.friendsViewModel.addFriend(User(match.starter + "'s Group", ""))
    }

    override fun addPending(match: Match) {
        val size: Int = this.archiveMatchViewModel.archiveMatches.value!!.size
        this.pendingMatchViewModel.add(match)
        this.mMatchAdapter.notifyItemInserted(size)
    }

    override fun removePending(position: Int) {
        this.pendingMatchViewModel.remove(position)
        val size: Int = this.archiveMatchViewModel.archiveMatches.value!!.size
        this.mMatchAdapter.notifyItemRemoved(position)
        this.mMatchAdapter.notifyItemRangeChanged(
            position, size
        )
    }

    override fun handleCheckIn() {
        FakeMatches.checked = true
        val fragmentManager: FragmentManager? = activity?.supportFragmentManager
        if (fragmentManager != null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.setReorderingAllowed(true)
            transaction.replace(
                R.id.next_match, RateMatchFragment()
            )
            transaction.commit()
        }
    }
}