package com.example.garbage_collector

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.garbage_collector.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    private lateinit var  binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEdittext.text.toString()

            if(!Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(),email)){
                binding.emailEditText.error = "Invalid email"
                return@setOnClickListener
            }

            if(password.length < 6){
                binding.passwordEdittext.error = "Length should be 6 char"
                return@setOnClickListener
            }


            loginWithFirebase(email,password)
            startActivity(Intent(this,Lang::class.java))
        }

        binding.gotoSignupBtn.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }

    }

    private fun loginWithFirebase(email : String, password: String){
        setInProgress(true)
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                setInProgress(false)
                startActivity(Intent(this@MainActivity, MainActivity::class.java))
                finish()
            }.addOnFailureListener {
                setInProgress(false)
                Toast.makeText(applicationContext,"Login successfully", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onResume() {
        super.onResume()
        FirebaseAuth.getInstance().currentUser?.apply {
            startActivity(Intent(this@MainActivity,Lang::class.java))
            finish()
        }
    }

    private fun setInProgress(inProgress : Boolean){
        if(inProgress){
            binding.loginBtn.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.loginBtn.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }
}
