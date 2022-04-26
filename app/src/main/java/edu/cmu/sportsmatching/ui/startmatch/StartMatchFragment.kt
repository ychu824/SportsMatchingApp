package edu.cmu.sportsmatching.ui.startmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.CalendarView.OnDateChangeListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.databinding.FragmentStartmatchBinding


class StartMatchFragment(var archiveMatchViewModel: ArchiveMatchViewModel) : Fragment() {

    private lateinit var binding: FragmentStartmatchBinding
    private lateinit var startMatchViewModel: StartMatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStartmatchBinding.inflate(layoutInflater)
        val date = binding.startmatchDate
        val startTime = binding.startmatchEtStartTime
        val endTime = binding.startmatchEtEndTime

        val sport_type = binding.startmatchSportsTypeDropdown
        val num_teammates = binding.startmatchEtNumTeamMates


        startMatchViewModel = ViewModelProvider(this, StartMatchViewModelFactory())
            .get(StartMatchViewModel::class.java)


    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //prof spinner part

        val v: View = inflater.inflate(R.layout.fragment_startmatch, container, false)


        var prof_type: String = "Beginner"
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
                prof_type = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        var sport_type: String = "Table Tennis"


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
                sport_type = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val teamNum: EditText = v.findViewById(R.id.startmatch_et_numTeamMates)
        var curDate: String = "March 30th"
        val calendarView: CalendarView = v.findViewById(R.id.startmatch_simpleCalendarView)
        calendarView.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            curDate = dayOfMonth.toString()
        })
        val startTime: EditText = v.findViewById(R.id.startmatch_et_startTime)

        val endTime: EditText = v.findViewById(R.id.startmatch_et_endTime)


        //continue_button
        val continue_button: Button = v.findViewById(R.id.startmatch_continue_button)


        continue_button.setOnClickListener {
//            val canContinue: Boolean = startMatchViewModel.startMatchState.value!!.isContinueValid
//            if (!canContinue) {
//                var error: String
//                if (startMatchViewModel.startMatchState.value!!.startTimeError != null) {
//                    error = startMatchViewModel.startMatchState.value!!.startTimeError!!
//                } else {
//                    error = startMatchViewModel.startMatchState.value!!.teammatesNumError!!
//                }
//                Toast.makeText(
//                    activity,
//                    error,
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else {


//            if (!canContinue) {
//                var error: String
//                if (startMatchViewModel.startMatchState.value!!.startTimeError != null) {
//                    error = startMatchViewModel.startMatchState.value!!.startTimeError!!
//                } else {
//                    error = startMatchViewModel.startMatchState.value!!.teammatesNumError!!
//                }
//                Toast.makeText(
//                    activity,
//                    error,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }else{
                var match: Match = Match(
                    starter = "Me",
                    currentTeam = teamNum.text.toString().toInt(),
                    sport = sport_type,
                    startTime = startTime.text.toString(),
                    endTime = endTime.text.toString(),
                    date = curDate,
                    participants = listOf()
                )
//            archiveMatchViewModel.archiveMatches.value!!.add(match)
                continue_button.isEnabled = true
                val fragmentManager: FragmentManager? = activity?.supportFragmentManager
                if (fragmentManager != null) {
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(
                        R.id.main_fragment_container,
                        StartMatchPostFragment(archiveMatchViewModel, match)
                    )
                    transaction.commit()
                    transaction.addToBackStack(null)
                }
//            }




        }

        return v
    }


}