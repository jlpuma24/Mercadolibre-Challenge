package com.melichallenge.presentation.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.melichallenge.R

const val SPLASH_DELAY: Long = 2000

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(this, SearchActivity::class.java))
            finish()
        }, SPLASH_DELAY)
    }
}