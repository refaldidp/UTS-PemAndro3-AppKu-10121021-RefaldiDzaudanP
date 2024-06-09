package com.example.appku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appku.R

class DailyActivityFragment : Fragment() {

    // Dummy list of friends
    private val friendsListItems = listOf(
        Friend("Bambang", R.drawable.ic_friend),
        Friend("Eric", R.drawable.ic_friend),
        Friend("Ryan", R.drawable.ic_friend),
        Friend("Reynaldi", R.drawable.ic_friend),
        Friend("Fakhmy", R.drawable.ic_friend),
        Friend("Sayid", R.drawable.ic_friend),
        Friend("Gilang", R.drawable.ic_friend),
        Friend("Berlian", R.drawable.ic_friend),
        Friend("Arya", R.drawable.ic_friend),
        Friend("Rafli", R.drawable.ic_friend),
        Friend("Ravi", R.drawable.ic_friend)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_daily_activity, container, false)

        // Setup RecyclerView for daily activities
        val dailyActivityList = view.findViewById<RecyclerView>(R.id.daily_activity_list)
        dailyActivityList.layoutManager = LinearLayoutManager(context)

        // Dummy data for daily activities
        val activities = listOf(
            "Bangun Pagi dan Sarapan",
            "Kelas Pagi",
            "Makan Siang di Kampus",
            "Istirahat Singkat ",
            "Kuliah Siang",
            "Perjalanan pulang",
            "Olahraga Ringan",
            "Makan Malam",
            "Studi atau Kerja Proyek",
            "Tidur"

        )

        // Set adapter for daily activity list
        dailyActivityList.adapter = DailyActivityAdapter(activities)

        // Setup RecyclerView for friends list
        val recyclerViewFriendsList = view.findViewById<RecyclerView>(R.id.recyclerViewFriendsList)
        recyclerViewFriendsList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewFriendsList.adapter = FriendsAdapter(friendsListItems)

        return view
    }

    // Data class for friends
    data class Friend(val name: String, val imageResource: Int)
}
