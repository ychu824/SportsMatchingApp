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


            //if valid
//            get match


            if (postTitle.text.toString().isEmpty()) {
                Toast.makeText(activity, "Title cannot be empty!", Toast.LENGTH_SHORT).show()
            } else if (mainText.text.toString().isEmpty()) {
                Toast.makeText(activity, "Text cannot be empty!", Toast.LENGTH_SHORT).show()
            } else if (location.text.toString().isEmpty()) {
                Toast.makeText(activity, "Location cannot be empty!", Toast.LENGTH_SHORT).show()
            } else {
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
                    imageUri = "https://cdn.vox-cdn.com/thumbor/l3P7vpY-Onaliz9OsgUz3y2mlh0=/0x0:4022x2681/920x613/filters:focal(1627x217:2269x859):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/70624496/usa_today_17896947.0.jpg"
                )

                archiveMatchViewModel.add(curMatch)

                val fragmentManager: FragmentManager? = activity?.supportFragmentManager
                if (fragmentManager != null) {
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(
                        R.id.main_fragment_container,
                        ArchiveFragment(archiveMatchViewModel)
                    )
                    transaction.commit()
                    transaction.addToBackStack(null)
                }
            }

        }
        return v
    }
}