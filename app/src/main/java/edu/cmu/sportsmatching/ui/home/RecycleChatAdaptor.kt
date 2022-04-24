package edu.cmu.sportsmatching.ui.home

import edu.cmu.sportsmatching.ui.home.Chat
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import edu.cmu.sportsmatching.R

class RecycleChatAdaptor(private val chatList: List<Chat>) :
    RecyclerView.Adapter<RecycleChatAdaptor.ChatViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ChatViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.chat_input, viewGroup, false)
        return ChatViewHolder(view)
    }

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chatText: TextView = itemView.findViewById(R.id.chatText)
//        init {
//
//        }
    }

    override fun onBindViewHolder(viewHolder: ChatViewHolder, i: Int) {
        val chat = chatList[i]
        viewHolder.chatText.text = chat.content
        val params = LinearLayout.LayoutParams(viewHolder.chatText.layoutParams)
        if (chat.targetUser == "Zhang San") {
            params.gravity = Gravity.LEFT
        } else {
            params.gravity = Gravity.RIGHT
        }
        viewHolder.chatText.layoutParams = params
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

}