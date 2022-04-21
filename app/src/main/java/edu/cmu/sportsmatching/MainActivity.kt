package edu.cmu.sportsmatching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.cmu.sportsmatching.data.mock.FakeMatches.users
import edu.cmu.sportsmatching.databinding.ActivityMainBinding
import edu.cmu.sportsmatching.ui.home.TeamMemberAdaptor

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
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }

                R.id.friends -> {
                    Toast.makeText(this, "Friends", Toast.LENGTH_SHORT).show()
                }

                R.id.start_match -> {
                    Toast.makeText(this, "Start Match", Toast.LENGTH_SHORT).show()
                }

                R.id.chat_room -> {
                    Toast.makeText(this, "Chat room", Toast.LENGTH_SHORT).show()
                }

                R.id.user_profile -> {
                    Toast.makeText(this, "Chat room", Toast.LENGTH_SHORT).show()
                }

            }
            true
        }

//        listView = findViewById(R.id.list)
//        val adapter = TeamMemberAdaptor(this, R.layout.team_member, users)
//        listView.adapter = adapter

    }

}