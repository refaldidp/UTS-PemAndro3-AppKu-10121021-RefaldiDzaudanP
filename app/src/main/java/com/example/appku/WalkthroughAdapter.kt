package com.example.appku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
class WalkthroughAdapter(private val layouts: List<Int>, private val listener: () -> Unit) : RecyclerView.Adapter<WalkthroughAdapter.WalkthroughViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalkthroughViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return WalkthroughViewHolder(view)
    }

    override fun onBindViewHolder(holder: WalkthroughViewHolder, position: Int) {
        if (position == layouts.size - 1) {
            val buttonGetStarted = holder.itemView.findViewById<Button>(R.id.buttonGetStarted)
            buttonGetStarted.setOnClickListener { listener.invoke() }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return layouts[position]
    }

    override fun getItemCount(): Int {
        return layouts.size
    }

    class WalkthroughViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

