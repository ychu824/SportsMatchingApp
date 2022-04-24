package edu.cmu.sportsmatching.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.Match
import edu.cmu.sportsmatching.data.model.Type
import kotlin.math.log

class MatchInfoAdapter(
    val matches: ArrayList<Match>,
    private val onMatchListener: OnMatchListener
) :
    RecyclerView.Adapter<MatchInfoAdapter.MatchViewHolder>() {

    interface OnMatchListener {
        fun onMatchClick(position: Int)
    }

    inner class MatchViewHolder(
        itemView: View,
        private val onMatchListener: OnMatchListener
    ) : RecyclerView.ViewHolder(itemView) {
        var userName: TextView = itemView.findViewById(R.id.user_name)
        var matchTitle: TextView = itemView.findViewById(R.id.match_title)
        var matchPostImage: ImageView = itemView.findViewById(R.id.match_post_image)
        var matchLocation: TextView = itemView.findViewById(R.id.match_location)
        var matchSport: TextView = itemView.findViewById(R.id.match_sport)
        var matchTeam: TextView = itemView.findViewById(R.id.match_team)
        var matchTime: TextView = itemView.findViewById(R.id.match_time)
        var acceptBtn: Button = itemView.findViewById(R.id.accept)
        var closeBtn: Button = itemView.findViewById(R.id.dismiss)
        init {
            itemView.setOnClickListener {
                this.onMatchListener.onMatchClick(this.adapterPosition)
            }
            this.acceptBtn.setOnClickListener {
                removeAt(this.adapterPosition)
                // TODO: add current match to archive
            }
            this.closeBtn.setOnClickListener {
                removeAt(this.adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_info, parent, false)
        return MatchViewHolder(view, this.onMatchListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matches[position]
        holder.userName.text = match.starter
        if (match.type == Type.MATCH_INVITATION) {
            holder.matchTitle.text = match.title
        } else {
            holder.matchTitle.text = "Friend Request"
            holder.matchTitle.setTextColor(ContextCompat.getColor(holder.matchTitle.context, R.color.accent_color))
        }
        // FIXME: real uri here
//        holder.matchPostImage.setImageURI(Uri.parse(match.imageUri))
        holder.matchPostImage.setImageResource(R.drawable.basketball_on_court)
        holder.matchLocation.text = "Location: " + match.location
        holder.matchSport.text = "Sport: " + match.sport
        if (match.type == Type.MATCH_INVITATION) {
            holder.matchTeam.text = "Team: " + match.currentTeam + "/" + match.totalTeam
        } else {
            holder.matchTeam.width = 0
            holder.matchTeam.height = 0;
            holder.matchTeam.isInvisible = true
        }
        holder.matchTime.text = "Time: " + match.startTime + " - " + match.endTime + " " + match.date
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    fun removeAt(position: Int) {
        this.matches.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, this.matches.size)
    }
}