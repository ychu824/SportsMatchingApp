package edu.cmu.sportsmatching.ui.home

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.model.Match

class MatchInfoAdapter(private val matches: List<Match>) :
    RecyclerView.Adapter<MatchInfoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userName: TextView = itemView.findViewById(R.id.user_name)
        var matchTitle: TextView = itemView.findViewById(R.id.match_title)
        var matchPostImage: ImageView = itemView.findViewById(R.id.match_post_image)
        var matchLocation: TextView = itemView.findViewById(R.id.match_location)
        var matchSport: TextView = itemView.findViewById(R.id.match_sport)
        var matchTeam: TextView = itemView.findViewById(R.id.match_team)
        var matchTime: TextView = itemView.findViewById(R.id.match_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_info, parent, false)

        // TODO: Set onClickListener on this view to see details
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matches[position]
        holder.userName.text = match.starter
        holder.matchTitle.text = match.title
//        holder.matchPostImage.setImageURI(Uri.parse(match.imageUri))
        holder.matchPostImage.setImageResource(R.drawable.basketball_on_court)
        holder.matchLocation.text = "Location: " + match.location
        holder.matchSport.text = "Sport: " + match.sport
        holder.matchTeam.text = "Team: " + match.currentTeam + "/" + match.totalTeam
        holder.matchTime.text = "Time: " + match.startTime + " - " + match.endTime + " " + match.date
    }

    override fun getItemCount(): Int {
        return matches.size
    }
}