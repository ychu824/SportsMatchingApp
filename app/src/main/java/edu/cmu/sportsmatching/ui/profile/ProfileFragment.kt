package edu.cmu.sportsmatching.ui.profile

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.cmu.sportsmatching.LoginActivity
import edu.cmu.sportsmatching.data.mock.FakeProfile
import edu.cmu.sportsmatching.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    companion object {
        private const val TAG = "ProfileFragment"
    }

    val name: String = FakeProfile.P_name
    val status: String = FakeProfile.P_status
    val workourTime: String = FakeProfile.P_time
    val sports: List<String> = FakeProfile.P_sports
    val timeList: List<Int> = FakeProfile.P_timelist
    val status_message: String = FakeProfile.P_status_message


    private lateinit var binding: FragmentProfileBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProfileBinding.inflate(layoutInflater)
//        binding.firstName.text = "First name: $name"
        binding.Name.text = name
        binding.Status.text = status
        binding.Sports0.text = sports[0]
        binding.Sports1.text = sports[1]
        binding.Sports2.text = sports[2]
        binding.Sports3.text = sports[3]
        binding.Sports4.text = sports[4]
        binding.Sports5.text = sports[5]
        binding.Sports6.text = sports[6]
        binding.Sports6.text = sports[6]
        binding.WorkoutTime.text = "Total work out time: $workourTime min."
        binding.WorkoutTime0.text = sports[0]+": "+timeList[0].toString()+" min."
        binding.WorkoutTime1.text = sports[1]+": "+timeList[1].toString()+" min."
        binding.WorkoutTime2.text = sports[2]+": "+timeList[2].toString()+" min."
        val simpleSeekBar0: SeekBar = binding.SeekBar0
        simpleSeekBar0.max = workourTime.toInt()
        simpleSeekBar0.progress = timeList[0]
        val simpleSeekBar1: SeekBar = binding.SeekBar1
        simpleSeekBar1.max = workourTime.toInt()
        simpleSeekBar1.progress = timeList[1]
        val simpleSeekBar2: SeekBar = binding.SeekBar2
        simpleSeekBar2.max = workourTime.toInt()
        simpleSeekBar2.progress = timeList[2]
//        binding.StatusMessage.text = status_message
        val rating = binding.ratingBar
        rating.setRating(4.25F)
        binding.button2.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.scrollToPositionWithOffset(0, 0)
        return binding.root
    }
}