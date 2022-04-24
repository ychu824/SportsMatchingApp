package edu.cmu.sportsmatching.ui.home

import android.app.AppComponentFactory
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.User

class ChatMemberAdapter(context: Context, val resourceId: Int, val data: ArrayList<User>, val fragmentManager: FragmentManager):
    ArrayAdapter<User>(context, resourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val userImage: ImageView = view.findViewById(R.id.user_avatar_friend)
            val userName: TextView = view.findViewById(R.id.user_name_friend)
            // TODO: real url
            val user = getItem(position)
            userImage.setImageResource(R.drawable.test_ava)
            if (user != null) {
                userName.text = user.name
                val chat: ImageView = view.findViewById(R.id.chat_icon)
                val chatListener = OnChatListener(fragmentManager, user)
                chat.setOnClickListener {
                    chatListener.onChatClick()
                }
            }
            return view
        }
}