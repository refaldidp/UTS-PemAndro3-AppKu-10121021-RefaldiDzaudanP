package com.example.appku


import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicFavoriteAdapter(private val musicItems: List<Music>) :
    RecyclerView.Adapter<MusicFavoriteAdapter.MusicViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentlyPlayingPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val item = musicItems[position]
        holder.name.text = item.name
        holder.image.setImageResource(item.imageRes)

        holder.playButton.setOnClickListener {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(holder.itemView.context, item.musicRes)
                mediaPlayer?.start()
                currentlyPlayingPosition = position
            } else {
                if (currentlyPlayingPosition != position) {
                    mediaPlayer?.reset()
                    mediaPlayer = MediaPlayer.create(holder.itemView.context, item.musicRes)
                    mediaPlayer?.start()
                    currentlyPlayingPosition = position
                } else {
                    mediaPlayer?.start()
                }
            }
        }

        holder.pauseButton.setOnClickListener {
            mediaPlayer?.pause()
        }

    }

    override fun getItemCount(): Int {
        return musicItems.size
    }

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageMusic)
        val name: TextView = itemView.findViewById(R.id.nameMusic)
        val playButton: Button = itemView.findViewById(R.id.buttonPlayMusic)
        val pauseButton: Button = itemView.findViewById(R.id.buttonPauseMusic)
    }
}
data class Music(val name: String, val imageRes: Int, val musicRes: Int)