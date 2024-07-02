package com.example.garbage_collector

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class formfill : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formfill)
        val lang = findViewById<Button>(R.id.reward)
        lang.setOnClickListener {
            Toast.makeText(applicationContext,"proceed to next page", Toast.LENGTH_SHORT).show()
            intent = Intent(applicationContext,formfill::class.java)
            startActivity(intent)
        }
    }
}