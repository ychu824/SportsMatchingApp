package edu.cmu.sportsmatching.ui.archive

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
import kotlin.math.log

class DetailInfoAdapter(
    var matches: ArrayList<Match>,
    private val onMatchListener: OnMatchListener
) :
    RecyclerView.Adapter<DetailInfoAdapter.MatchViewHolder>() {

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
        init {
            itemView.setOnClickListener {
                this.onMatchListener.onMatchClick(this.adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.brief_match_info, parent, false)
        return MatchViewHolder(view, this.onMatchListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matches[position]
        holder.userName.text = match.starter
        holder.matchTitle.text = match.title
        // FIXME: real uri here
//        holder.matchPostImage.setImageURI(Uri.parse(match.imageUri))
        holder.matchLocation.text = "Location: " + match.location
        holder.matchSport.text = "Sport: " + match.sport
        holder.matchTeam.text = "Team: " + match.currentTeam + "/" + match.totalTeam
        holder.matchTime.text = "Time: " + match.startTime + " - " + match.endTime + " " + match.date
        holder.matchPostImage.setImageResource(match.imageUri)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    fun update(list : ArrayList<Match>){
        matches = list
        this.notifyDataSetChanged()
    }
}