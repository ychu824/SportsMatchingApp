package edu.cmu.sportsmatching.ui.home

import android.view.View
import android.widget.EditText
import android.widget.Spinner
import edu.cmu.sportsmatching.ui.home.Chat
import edu.cmu.sportsmatching.ui.home.RecycleChatAdaptor
import androidx.recyclerview.widget.RecyclerView

class ChatSubmitListener(
    private val chatContent: EditText,
    private val targetUser: Spinner,
    private val chatData: MutableList<Chat>,
    private val chatAdapter: RecycleChatAdaptor,
    private val chatList: RecyclerView
) {
    fun onClick(v: View?) {

    }
}