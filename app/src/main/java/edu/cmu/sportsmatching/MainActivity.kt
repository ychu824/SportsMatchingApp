package edu.cmu.sportsmatching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.cmu.sportsmatching.databinding.ActivityMainBinding
import edu.cmu.sportsmatching.ui.archive.ArchiveFragment
import edu.cmu.sportsmatching.ui.home.ChatFragment
import edu.cmu.sportsmatching.ui.home.FriendsViewModel
import edu.cmu.sportsmatching.ui.home.FriendsViewModelFactory
import edu.cmu.sportsmatching.ui.home.HomeFragment
import edu.cmu.sportsmatching.ui.startmatch.*
import edu.cmu.sportsmatching.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var mArchiveMatchViewModel: ArchiveMatchViewModel
    private lateinit var mPendingMatchViewModel: PendingMatchViewModel
    private lateinit var mFriendsViewModel: FriendsViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var mBottomNavigation: BottomNavigationView
    lateinit var mFragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mArchiveMatchViewModel = ViewModelProvider(this, ArchiveMatchFactory())
            .get(ArchiveMatchViewModel::class.java)
        mPendingMatchViewModel = ViewModelProvider(this, PendingMatchFactory())
            .get(PendingMatchViewModel::class.java)
        mFriendsViewModel = ViewModelProvider(this, FriendsViewModelFactory())
            .get(FriendsViewModel::class.java)
        mBottomNavigation = binding.navigation
        mFragmentManager = supportFragmentManager
        val transaction = mFragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(R.id.main_fragment_container, HomeFragment(
            mPendingMatchViewModel, mArchiveMatchViewModel, mFriendsViewModel))
        transaction.commit()

        mBottomNavigation.setOnNavigationItemSelectedListener {
            Log.d(TAG, "Bottom Navigation item is selected.")
            when (it.itemId) {
                R.id.home -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(R.id.main_fragment_container, HomeFragment(
                        mPendingMatchViewModel, mArchiveMatchViewModel, mFriendsViewModel))
                    transaction.commit()
                }

                R.id.friends -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.main_fragment_container, ChatFragment(mFriendsViewModel))
                    transaction.commit()
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