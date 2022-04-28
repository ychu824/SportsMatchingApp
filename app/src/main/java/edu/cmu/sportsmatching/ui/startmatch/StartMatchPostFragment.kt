package edu.cmu.sportsmatching.ui.startmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.databinding.FragmentStartmatchBinding
import edu.cmu.sportsmatching.databinding.FragmentStartmatchpostBinding
import edu.cmu.sportsmatching.ui.archive.ArchiveFragment

class StartMatchPostFragment(var archiveMatchViewModel: ArchiveMatchViewModel, var match: Match) :
    Fragment() {
    private lateinit var binding: FragmentStartmatchpostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStartmatchpostBinding.inflate(layoutInflater)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_startmatchpost, container, false)

        val backButton: ImageButton = v.findViewById(R.id.post_back)
        backButton.setOnClickListener {
            val fragmentManager: FragmentManager? = activity?.supportFragmentManager
            if (fragmentManager != null) {
                val transaction = fragmentManager.beginTransaction()
                transaction.setReorderingAllowed(true)
                transaction.replace(
                    R.id.main_fragment_container,
                    StartMatchFragment(archiveMatchViewModel)
                )
                transaction.commit()
                transaction.addToBackStack(null)
            }
        }

        val postTitle: EditText = v.findViewById(R.id.post_titleinput)
        val mainText: EditText = v.findViewById(R.id.post_multilineinput)
        val location: EditText = v.findViewById(R.id.post_location_input)

        val postButton = v.findViewById<Button>(R.id.post_post)
        postButton.setOnClickListener {


            if (postTitle.text.toString().isEmpty()) {
                Toast.makeText(activity, "Title cannot be empty!", Toast.LENGTH_SHORT).show()
            } else if (mainText.text.toString().isEmpty()) {
                Toast.makeText(activity, "Text cannot be empty!", Toast.LENGTH_SHORT).show()
            } else if (location.text.toString().isEmpty()) {
                Toast.makeText(activity, "Location cannot be empty!", Toast.LENGTH_SHORT).show()
            } else {
                var imageUri = findImage(match.sport)
                var curMatch: Match = Match(
                    title = postTitle.text.toString(),
                    mainText = mainText.text.toString(),
                    location = location.text.toString(),
                    starter = "Me",
                    currentTeam = match.currentTeam,
                    sport = match.sport,
                    startTime = match.startTime,
                    endTime = match.endTime,
                    date = match.date,
                    participants = listOf(),
                    totalTeam = match.currentTeam,
                    imageUri = imageUri
                )

                archiveMatchViewModel.add(curMatch)

                val fragmentManager: FragmentManager? = activity?.supportFragmentManager
                if (fragmentManager != null) {
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(
                        R.id.main_fragment_container,
                        MatchCreateFragment(archiveMatchViewModel)
                    )
                    transaction.commit()
                    transaction.addToBackStack(null)
                }
            }

        }
        return v
    }

    private fun findImage(sport: String?): Int {

        if (sport == "Table Tennis") {
            return R.drawable.table_tennis
        } else if (sport == "Basketball") {
            return R.drawable.basketball_on_court
        } else if (sport == "Badminton") {
            return R.drawable.badminton
        } else if (sport == "Tennis") {
            return R.drawable.tennis
        } else if (sport == "Chess") {
            return R.drawable.chess
        } else if (sport == "Soccer") {
            return R.drawable.soccer
        } else {
            return R.drawable.sports
        }

    }
}