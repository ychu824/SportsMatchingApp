package edu.cmu.sportsmatching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.cmu.sportsmatching.databinding.ActivityMainBinding
import edu.cmu.sportsmatching.ui.archive.ArchiveFragment
import edu.cmu.sportsmatching.ui.home.HomeFragment
import edu.cmu.sportsmatching.ui.profile.ProfileFragment
import edu.cmu.sportsmatching.ui.startmatch.StartMatchFragment

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var mBottomNavigation: BottomNavigationView
    lateinit var mFragmentManager: FragmentManager
    private lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBottomNavigation = binding.navigation
        mFragmentManager = supportFragmentManager

        mBottomNavigation.setOnNavigationItemSelectedListener {
            Log.d(TAG, "Bottom Navigation item is selected.")
            when (it.itemId) {
                R.id.home -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(R.id.main_fragment_container, HomeFragment())
                    transaction.commit()
                }

                R.id.friends -> {
                    Toast.makeText(this, "Friends", Toast.LENGTH_SHORT).show()
                }

                R.id.start_match -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(R.id.main_fragment_container, StartMatchFragment())
                    transaction.commit()
                }

                R.id.chat_room -> {
                    val fragmentManager: FragmentManager = this.supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.setReorderingAllowed(true)
                    transaction.replace(R.id.main_fragment_container, ArchiveFragment())
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