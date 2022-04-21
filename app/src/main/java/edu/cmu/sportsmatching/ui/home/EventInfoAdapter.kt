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
import edu.cmu.sportsmatching.data.model.Event
import edu.cmu.sportsmatching.data.model.Match

class EventInfoAdapter(private val events: List<Event>) :
    RecyclerView.Adapter<EventInfoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var matchLocation: TextView = itemView.findViewById(R.id.detail_info_location)
        var matchSport: TextView = itemView.findViewById(R.id.detail_info_sport_type)
        var matchTeam: TextView = itemView.findViewById(R.id.detail_info_availability)
        var matchTime: TextView = itemView.findViewById(R.id.detail_info_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_detail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EventInfoAdapter.ViewHolder, position: Int) {
        val match = events[position]
        holder.matchLocation.text = "Location: " + match.location
        holder.matchSport.text = "Sport: " + match.sport_type
        holder.matchTeam.text = "Team: " + match.ocur_spots + "/" + match.all_spots
        holder.matchTime.text = "Time: " + match.start_time + " - " + match.end_time + " " + match.date
    }
}