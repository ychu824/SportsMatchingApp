package edu.cmu.sportsmatching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.databinding.ActivityMainBinding
import edu.cmu.sportsmatching.ui.archive.ArchiveFragment
import edu.cmu.sportsmatching.ui.home.ChatFragement
import edu.cmu.sportsmatching.ui.home.DetailPageFragment
import edu.cmu.sportsmatching.ui.home.HomeFragment
import edu.cmu.sportsmatching.ui.startmatch.*
import edu.cmu.sportsmatching.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var mArchiveMatchViewModel: ArchiveMatchViewModel
    private lateinit var mPendingMatchViewModel: PendingMatchViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var mBottomNavigation: BottomNavigationView
    lateinit var mFragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mArchiveMatchViewModel = ViewModelProvider(this, ArchiveMatchFactory())
            .get(ArchiveMatchViewModel::class.java)
        mPendingMatchViewModel =
            ViewModelProvider(this, PendingMatchFactory()).get(
                PendingMatchViewModel::class.java
            )
        mBottomNavigation = binding.navigation
        mFragmentManager = supportFragmentManager
        val transaction = mFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(R.id.main_fragment_container, HomeFragment(mPendingMatchViewModel, mArchiveMatchViewModel))
        transaction.commit()

        mBottomNavigation.setOnNavigationItemSelectedListener {
            Log.d(TAG, "Bottom Navigation item is selected.")
            when (it.itemId) {
                R.id.home -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    //TODO send param to homefragment
                    transaction.replace(R.id.main_fragment_container, HomeFragment(mPendingMatchViewModel, mArchiveMatchViewModel))
                    transaction.commit()
                }

                R.id.friends -> {
                    Toast.makeText(this, "Friends", Toast.LENGTH_SHORT).show()
                    val fragmentManager: FragmentManager? = this?.supportFragmentManager
                    if (fragmentManager != null) {
                        val transaction = fragmentManager.beginTransaction()
                        transaction.replace(R.id.main_fragment_container, ChatFragement())
                        transaction.commit()
                    }
                }

                R.id.start_match -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(R.id.main_fragment_container, StartMatchFragment(mArchiveMatchViewModel))
                    transaction.commit()
                }

                R.id.chat_room -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(R.id.main_fragment_container, ArchiveFragment(mArchiveMatchViewModel))
                    transaction.commit()
                }

                R.id.user_profile -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(R.id.main_fragment_container, ProfileFragment())
                    transaction.commit()
                }

            }
            true
        }
    }

}