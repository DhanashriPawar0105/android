package com.example.garbage_collector

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        android.os.Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },2000)
    }
}
