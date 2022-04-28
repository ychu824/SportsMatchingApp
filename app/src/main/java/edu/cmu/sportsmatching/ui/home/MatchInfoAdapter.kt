package edu.cmu.sportsmatching.ui.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.Match
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import edu.cmu.sportsmatching.data.model.Type

class MatchInfoAdapter(
    val matches: ArrayList<Match>,
    private val onMatchListener: OnMatchListener,
    private val archiveMatchesHandler: ArchiveMatchesHandler,
    private val pendingMatchesHandler: PendingMatchesHandler
) :
    RecyclerView.Adapter<MatchInfoAdapter.MatchViewHolder>() {

    interface OnMatchListener {
        fun onMatchClick(position: Int)
    }

    interface ArchiveMatchesHandler {
        fun add(match: Match)
    }

    interface PendingMatchesHandler {
        fun addPending(match: Match)
        fun removePending(position: Int)
    }


    inner class MatchViewHolder(
        itemView: View,
        private val onMatchListener: OnMatchListener,
        private val archiveMatchesHandler: ArchiveMatchesHandler,
        private val pendingMatchesHandler: PendingMatchesHandler
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
                val selectedMatch: Match = matches[this.adapterPosition]
                this.archiveMatchesHandler.add(selectedMatch)
                // remove match from pending archive
                this.pendingMatchesHandler.removePending(this.adapterPosition)
            }
            this.closeBtn.setOnClickListener {
                this.pendingMatchesHandler.removePending(this.adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_info, parent, false)
        return MatchViewHolder(
            view,
            this.onMatchListener,
            archiveMatchesHandler,
            pendingMatchesHandler
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matches[position]
        holder.userName.text = match.starter
        if (match.type == Type.MATCH_INVITATION) {
            holder.matchTitle.text = match.title
            holder.matchTitle.setTextColor(
                ContextCompat.getColor(holder.matchTitle.context, R.color.black)
            )
        } else {
            holder.matchTitle.text = "Friend Request"
            holder.matchTitle.setTextColor(
                ContextCompat.getColor(holder.matchTitle.context, R.color.black)
            )
        }
        // FIXME: real uri here
//        holder.matchPostImage.setImageURI(Uri.parse(match.imageUri))
        holder.matchPostImage.setImageResource(match.imageUri)
        holder.matchLocation.text = "Location: " + match.location
        holder.matchSport.text = "Sport: " + match.sport
        if (match.type == Type.MATCH_INVITATION) {
            holder.matchTeam.text = "Team: " + match.currentTeam + "/" + match.totalTeam
        } else {
            holder.matchTeam.width = 0
            holder.matchTeam.height = 0;
            holder.matchTeam.isInvisible = true
        }
        holder.matchTime.text =
            "Time: " + match.startTime + " - " + match.endTime + " " + match.date
    }

    override fun getItemCount(): Int {
        return matches.size
    }
}