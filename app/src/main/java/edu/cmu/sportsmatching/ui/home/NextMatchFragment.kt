package edu.cmu.sportsmatching.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.cmu.sportsmatching.databinding.NextMatchInfoBinding

class NextMatchFragment(private val handler: CheckInHandler) : Fragment() {
    private lateinit var binding: NextMatchInfoBinding
    private lateinit var mCheckIn: TextView

    interface CheckInHandler {
        fun handleCheckIn()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NextMatchInfoBinding.inflate(layoutInflater)
        mCheckIn = binding.checkIn
        mCheckIn.setOnClickListener {
            this.handler.handleCheckIn()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}