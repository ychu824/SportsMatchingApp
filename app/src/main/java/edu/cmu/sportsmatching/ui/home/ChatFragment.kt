package edu.cmu.sportsmatching.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.databinding.ChatMainBinding
import edu.cmu.sportsmatching.databinding.FragmentDetailBinding

class ChatFragment(private val friendsViewModel: FriendsViewModel): Fragment() {
    companion object {
        private const val TAG = "ChatFragment"
    }

    private lateinit var binding: ChatMainBinding
    private lateinit var chatAdapter: ChatMemberAdapter
    private lateinit var frag: OnChatListener


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChatMainBinding.inflate(layoutInflater)
        val fragmentManager: FragmentManager? = activity?.supportFragmentManager
        if (fragmentManager != null) {
            val adapter = ChatMemberAdapter(
                this.requireContext(), R.layout.friend,
                friendsViewModel.friends.value!!, fragmentManager
            )
            binding.friendList.adapter = adapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        return binding.root
    }

}