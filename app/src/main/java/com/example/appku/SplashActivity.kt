package com.example.appku


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Simulasi delay untuk splash screen
        val splashScreenTimeOut = 3000
        val homeIntent = Intent(this, WalkthroughActivity::class.java)

        android.os.Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, splashScreenTimeOut.toLong())
    }
}
