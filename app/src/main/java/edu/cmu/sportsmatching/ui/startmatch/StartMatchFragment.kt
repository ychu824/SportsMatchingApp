package edu.cmu.sportsmatching.ui.startmatch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.databinding.FragmentStartmatchBinding
import edu.cmu.sportsmatching.ui.home.MatchInfoAdapter


class StartMatchFragment(var archiveMatchViewModel: ArchiveMatchViewModel) : Fragment() {

    private lateinit var mMatchAdapter: MatchInfoAdapter
    private lateinit var binding: FragmentStartmatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStartmatchBinding.inflate(layoutInflater)
        val date = binding.startmatchDate
        val startTime = binding.startmatchEtStartTime
        val endTime = binding.startmatchEtEndTime

        val sport_type = binding.startmatchSportsTypeDropdown
        val num_teammates = binding.startmatchEtNumTeamMates


    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //prof spinner part

        val v: View = inflater.inflate(R.layout.fragment_startmatch, container, false)
        var prof_spinner: Spinner = v.findViewById(R.id.startmatch_proficiency_dropdown)
        val prof_adapter = ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.proficiency_dropdown,
            android.R.layout.simple_spinner_item,
        )
        prof_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        prof_spinner.adapter = prof_adapter
        prof_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                TODO("Not yet implemented")
                val text: String = parent?.getItemAtPosition(position).toString()
                System.err.println(text)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

//        sport_type spinner part
        var sport_type_spinner: Spinner = v.findViewById(R.id.startmatch_sportsType_dropdown)
        val sport_type_adapter = ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.sportsType_dropdown,
            android.R.layout.simple_spinner_item
        )
        sport_type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sport_type_spinner.adapter = sport_type_adapter
        sport_type_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        //continue_button
        val continue_button : Button = v.findViewById(R.id.startmatch_continue_button)


        continue_button.setOnClickListener {
            Log.d("Con", "Continue button")
            val fragmentManager: FragmentManager? = activity?.supportFragmentManager
            if (fragmentManager != null) {
                val transaction = fragmentManager.beginTransaction()
                transaction.setReorderingAllowed(true)
                transaction.replace(R.id.main_fragment_container, StartMatchPostFragment(archiveMatchViewModel))
                transaction.commit()
                transaction.addToBackStack(null)
            }

        }

        return v
    }


}