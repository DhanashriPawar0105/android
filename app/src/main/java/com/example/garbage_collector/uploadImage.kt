package com.example.garbage_collector

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class uploadImage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_upload_image)
            val cameraview = findViewById<ImageButton>(R.id.cameraview)



            cameraview.setOnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
            }

        val formfill = findViewById<Button>(R.id.confirm)
        formfill.setOnClickListener {
            Toast.makeText(applicationContext,"proceed to next page", Toast.LENGTH_SHORT).show()
            intent = Intent(applicationContext,formfill::class.java)
            startActivity(intent)
        }
        }
    }
