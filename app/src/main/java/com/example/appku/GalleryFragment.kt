package com.example.appku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var galleryAdapter: GalleryAdapter
    private val galleryItems = listOf(
        R.drawable.gal1,
        R.drawable.gal2,
        R.drawable.gal3,
        R.drawable.gal4,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewGallery)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        galleryAdapter = GalleryAdapter(galleryItems)
        recyclerView.adapter = galleryAdapter

        return view
    }
}