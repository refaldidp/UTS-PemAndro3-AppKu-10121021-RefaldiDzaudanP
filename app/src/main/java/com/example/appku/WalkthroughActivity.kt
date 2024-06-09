package com.example.appku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


class WalkthroughActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: WalkthroughAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        viewPager = findViewById(R.id.viewPager)
        val layouts = listOf(R.layout.walkthrough_page_1, R.layout.walkthrough_page_2, R.layout.walkthrough_page_3)
        adapter = WalkthroughAdapter(layouts) {
            // Tangani klik tombol di sini
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        viewPager.adapter = adapter
    }
}


