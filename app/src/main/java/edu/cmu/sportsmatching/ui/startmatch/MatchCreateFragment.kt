package edu.cmu.sportsmatching.ui.startmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.databinding.FragmentMatchcreateBinding

class MatchCreateFragment(var archiveMatchViewModel: ArchiveMatchViewModel) : Fragment() {
    private lateinit var binding: FragmentMatchcreateBinding
    private lateinit var mCloseButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMatchcreateBinding.inflate(layoutInflater)
        mCloseButton = binding.matchcreateClosebutton
        mCloseButton.setOnClickListener {
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
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}