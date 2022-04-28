package edu.cmu.sportsmatching.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.mock.FakeMatches.users
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.data.model.User
import edu.cmu.sportsmatching.databinding.FragmentDetailBinding

class DetailPageFragment(private val match: Match) : Fragment() {

    companion object {
        private const val TAG = "DetailPageFragment"
    }

    private lateinit var binding: FragmentDetailBinding

    private lateinit var listView: ListView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.detailTitle.text = match.title
        binding.remaining.text = "${match.totalTeam - match.currentTeam} remaining"
        binding.detailMainText.text = match.mainText
        binding.detailInfoLocation.text = "Location: ${match.location}"
        binding.detailInfoTime.text = "Time: ${match.startTime} - ${match.endTime} ${match.date}"
        binding.detailInfoSportType.text = "Sport: ${match.sport}"
        binding.detailInfoAvailability.text = "Team ${match.currentTeam}/${match.totalTeam}"
        binding.detailFieldPic.setImageResource(match.imageUri)
//
//        val adapter = TeamMemberAdaptor(this.requireContext(), R.layout.team_member, users)
//        listView = view?.findViewById<View>(R.id.list)
//        listView.adapter = adapter
        val adapter = TeamMemberAdaptor(this.requireContext(), R.layout.team_member, users)
        binding.list.adapter = adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.buttonBack.setOnClickListener {
            requireFragmentManager().popBackStack()
        }
        return binding.root
    }



}