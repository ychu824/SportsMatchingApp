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
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


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
        var curDate: String = ""
        val calendarView: CalendarView = v.findViewById(R.id.startmatch_simpleCalendarView)
        calendarView.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            curDate = dayOfMonth.toString()
        })
        val startTime: EditText = v.findViewById(R.id.startmatch_et_startTime)

        val endTime: EditText = v.findViewById(R.id.startmatch_et_endTime)


        //continue_button
        val continue_button: Button = v.findViewById(R.id.startmatch_continue_button)


        continue_button.setOnClickListener {

            if (!isTimeValid(startTime.text.toString(), endTime.text.toString())) {
                Toast.makeText(activity, "Start/End time incorrect!", Toast.LENGTH_SHORT).show()
            } else if (!isTeammateNumValid(teamNum.text.toString())) {
                Toast.makeText(activity, "Team member number incorrect!", Toast.LENGTH_SHORT).show()
            } else if (curDate == "") {
                Toast.makeText(activity, "Date is incorrect!", Toast.LENGTH_SHORT).show()
            } else {
                var match: Match = Match(
                    starter = "Me",
                    currentTeam = teamNum.text.toString().toInt(),
                    sport = sport_type,
                    startTime = startTime.text.toString(),
                    endTime = endTime.text.toString(),
                    date = curDate,
                    participants = listOf()
                )
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
            }


        }

        return v
    }

    private fun isTimeValid(startTime: String, endTime: String): Boolean {
        val regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]"
        val p: Pattern = Pattern.compile(regex)
        if (startTime == null || endTime == null) {
            return false
        }

        //validate corrent time
        val m_start: Matcher = p.matcher(startTime)
        if (m_start.matches() == false) {
            return false
        }
        val m_end: Matcher = p.matcher(endTime)
        if (m_end.matches() == false) {
            return false
        }

        // TODO: check start time precede to end time
        val start_hour = startTime.split(":")[0]
        val start_min = startTime.split(":")[1]
        val end_hour = endTime.split(":")[0]
        val end_min = endTime.split(":")[1]

        if (start_hour.toInt() > end_hour.toInt()) {
            return false
        }
        if (start_hour.toInt() == end_hour.toInt() && start_min.toInt() > end_min.toInt()) {
            return false
        }


        return true

    }

    private fun isTeammateNumValid(num: String): Boolean {
        val parsedInt: Int
        try {
            parsedInt = num.toInt()
        } catch (nfe: NumberFormatException) {
            // not a valid int
            return false
        }
        return parsedInt >= 1
    }


}