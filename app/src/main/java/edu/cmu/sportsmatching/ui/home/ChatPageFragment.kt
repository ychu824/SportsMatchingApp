package edu.cmu.sportsmatching.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.mock.FakeMatches
import edu.cmu.sportsmatching.data.model.User
import edu.cmu.sportsmatching.databinding.ChattingPageBinding

class ChatPageFragment(private val user: User): Fragment() {
    companion object {
        private const val TAG = "ChatPageFragment"
    }

    private lateinit var binding: ChattingPageBinding
    private lateinit var chatAdapter: RecycleChatAdaptor
    private lateinit var chatRecyclerView: RecyclerView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChattingPageBinding.inflate(layoutInflater)
        chatRecyclerView = binding.chatList
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.buttonBack.setOnClickListener {
            requireFragmentManager().popBackStack()
        }

        val chatData = ArrayList<Chat>()
        chatData.add(Chat("Zhang San", "hello"))
        chatData.add(Chat("Li Si", "hi"))
        this.chatAdapter = RecycleChatAdaptor(chatData)
        binding.chatList.adapter = chatAdapter
        layoutManager.scrollToPositionWithOffset(0, 0)
        chatRecyclerView.layoutManager = layoutManager
        chatRecyclerView.adapter = this.chatAdapter

        val chatContent = binding.chatContent
        val targetUser = binding.targetUser
        val data = listOf<String>("Yinghan Wang", "Zongyue Pu")
        val adapter = context?.let { ArrayAdapter<String>(it, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, data) }
        targetUser.adapter = adapter
        binding.chatSubmit.setOnClickListener {
            if (chatContent.text.toString() != "") {
                val user = targetUser.selectedItem.toString()
                chatData.add(Chat(user, chatContent.text.toString()))
                chatAdapter.notifyItemInserted(chatData.size - 1)
                binding.chatList.postInvalidate()
                binding.chatList.scrollToPosition(chatData.size - 1)
                chatContent.setText("")
            }
        }
        return binding.root
    }
}