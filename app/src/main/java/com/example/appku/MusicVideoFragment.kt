package com.example.appku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MusicVideoFragment : Fragment() {

    private lateinit var recyclerViewMusicFavorite: RecyclerView
    private lateinit var musicFavoriteAdapter: MusicFavoriteAdapter
    private val musicItems = listOf(
        Music("Akon-Smack That", R.drawable.akon, R.raw.akon_smack_that),
        Music("Travis Scott-Sicko Mode", R.drawable.travis, R.raw.travis_scott_sicko_mode),
        Music("Drake-God's Plan", R.drawable.drake, R.raw.drake_gods_plan),
        Music("Major Lazer-Lean On", R.drawable.major, R.raw.major_lazer_dj_snake_lean_on)
    )

    private lateinit var recyclerViewVideo: RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    private val videoItems = listOf(
        Video("Mission: Impossible – Ghost Protocol", R.drawable.mission_impossible_ghost_protocol,"Mission: Impossible – Ghost Protocol is a 2011 American action spy film directed by Brad Bird (in his live-action directorial debut) from a screenplay by the writing team of Josh Appelbaum and André Nemec, who also serve as co-producers."),
        Video("No Time to Die", R.drawable.no_time_to_die_poster,"No Time to Die is a 2021 spy film and the twenty-fifth in the James Bond series produced by Eon Productions, starring Daniel Craig in his fifth and final portrayal of fictional British MI6 agent James Bond."),
        Video("Jumanji: Welcome to the Jungle", R.drawable.jumanji_welcome_to_the_jungle,"Jumanji: Welcome to the Jungle is a 2017 American adventure comedy film directed by Jake Kasdan from a screenplay by the writing teams of Chris McKenna and Erik Sommers, and Scott Rosenberg and Jeff Pinkner, based on a story conceived by McKenna.")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music_video, container, false)

        recyclerViewMusicFavorite = view.findViewById(R.id.recyclerViewMusicFavorite)
        recyclerViewMusicFavorite.layoutManager = LinearLayoutManager(context)
        musicFavoriteAdapter = MusicFavoriteAdapter(musicItems)
        recyclerViewMusicFavorite.adapter = musicFavoriteAdapter

        recyclerViewVideo = view.findViewById(R.id.recyclerViewVideo)
        recyclerViewVideo.layoutManager = LinearLayoutManager(context)
        videoAdapter = VideoAdapter(videoItems)
        recyclerViewVideo.adapter = videoAdapter

        return view
    }
}

