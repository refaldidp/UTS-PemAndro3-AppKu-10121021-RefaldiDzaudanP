package com.example.appku

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val videoItems: List<Video>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vid, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val item = videoItems[position]
        holder.name.text = item.name
        holder.image.setImageResource(item.imageRes)
        holder.desk.text = item.desk

    }

    override fun getItemCount(): Int {
        return videoItems.size
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageVideo)
        val name: TextView = itemView.findViewById(R.id.nameVideo)
        val desk: TextView = itemView.findViewById(R.id.deskVideo)
    }
}
data class Video(val name: String, val imageRes: Int,val desk: String)