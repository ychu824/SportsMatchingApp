package edu.cmu.sportsmatching.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.databinding.FragmentDetailBinding

class DetailPageFragment(private val event: Match) : Fragment() {

    companion object {
        private const val TAG = "DetailPageFragment"
    }

    private lateinit var binding: FragmentDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.detailTitle.text = event.title
        binding.remaining.text = "${event.totalTeam - event.currentTeam} remaining"
        binding.detailMainText.text = event.mainText
        binding.detailInfoLocation.text = "Location: ${event.location}"
        binding.detailInfoTime.text = "Time: ${event.startTime} - ${event.endTime} ${event.date}"
        binding.detailInfoSportType.text = "Sport: ${event.sport}"
        binding.detailInfoAvailability.text = "Team ${event.currentTeam}/${event.totalTeam}"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        return binding.root
    }
}