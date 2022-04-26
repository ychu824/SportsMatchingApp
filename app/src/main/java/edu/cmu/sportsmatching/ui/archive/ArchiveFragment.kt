package edu.cmu.sportsmatching.ui.archive

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
import edu.cmu.sportsmatching.databinding.FragmentArchiveBinding
import edu.cmu.sportsmatching.databinding.FragmentHomeBinding
import edu.cmu.sportsmatching.ui.archive.DetailInfoAdapter
import edu.cmu.sportsmatching.ui.home.DetailPageFragment
import edu.cmu.sportsmatching.ui.startmatch.ArchiveMatchFactory
import edu.cmu.sportsmatching.ui.startmatch.ArchiveMatchViewModel

class ArchiveFragment(var mArchiveMatchViewModel: ArchiveMatchViewModel) : Fragment(),
    DetailInfoAdapter.OnMatchListener {

    companion object {
        private const val TAG = "ArchiveFragment"
    }

    private lateinit var mMatchInfoRecyclerView: RecyclerView
    private lateinit var mMatchAdapter: DetailInfoAdapter
    private lateinit var binding: FragmentArchiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentArchiveBinding.inflate(layoutInflater)
        mMatchInfoRecyclerView = binding.archiveRecyclerView

        this.mMatchAdapter = DetailInfoAdapter(
            mArchiveMatchViewModel.archiveMatches.value!!, this
        )
        mMatchInfoRecyclerView.adapter = this.mMatchAdapter
        mArchiveMatchViewModel.archiveMatches.observe(this@ArchiveFragment) {
            val archiveMatches = it ?: return@observe
            mMatchAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        // FIXME: Replace some mock data with real data here
        layoutManager.scrollToPositionWithOffset(0, 0)
        mMatchInfoRecyclerView.layoutManager = layoutManager


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
}