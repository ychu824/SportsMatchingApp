package edu.cmu.sportsmatching.ui.startmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.databinding.FragmentStartmatchBinding
import edu.cmu.sportsmatching.databinding.FragmentStartmatchpostBinding
import edu.cmu.sportsmatching.ui.archive.ArchiveFragment

class StartMatchPostFragment(var archiveMatchViewModel: ArchiveMatchViewModel) : Fragment(){
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

        val backButton : ImageButton = v.findViewById(R.id.post_back)
        backButton.setOnClickListener {
            val fragmentManager: FragmentManager? = activity?.supportFragmentManager
            if (fragmentManager != null) {
                val transaction = fragmentManager.beginTransaction()
                transaction.setReorderingAllowed(true)
                transaction.replace(R.id.main_fragment_container, StartMatchFragment(archiveMatchViewModel))
                transaction.commit()
                transaction.addToBackStack(null)
            }
        }

        val postButton = v.findViewById<Button>(R.id.post_post)
        postButton.setOnClickListener {
            val fragmentManager: FragmentManager? = activity?.supportFragmentManager
            if (fragmentManager != null) {
                val transaction = fragmentManager.beginTransaction()
                transaction.setReorderingAllowed(true)
                transaction.replace(R.id.main_fragment_container, ArchiveFragment(archiveMatchViewModel))
                transaction.commit()
                transaction.addToBackStack(null)
            }
        }
        return v
    }
}