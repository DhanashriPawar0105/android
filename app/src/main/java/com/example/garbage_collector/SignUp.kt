package com.example.garbage_collector

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.garbage_collector.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccountBtn.setOnClickListener {

            val email = binding.emailEdittext.text.toString()
            val password = binding.passwordEdittext.text.toString()
            val confirmPassword = binding.confirmPasswordEdittext.text.toString()

            if(!Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(),email)){
                binding.emailEdittext.error = "Invalid email"
                return@setOnClickListener
            }

            if(password.length < 6){
                binding.passwordEdittext.error = "Length should be 6 char"
                return@setOnClickListener
            }
            if (!password.equals(confirmPassword)){
                binding.confirmPasswordEdittext.error = "Password not matched"
                return@setOnClickListener
            }

            createAccountWithFirebase(email,password)
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.gotoLoginBtn.setOnClickListener {
            startActivity(Intent(this@SignUp, MainActivity::class.java))
            finish()
        }
    }

    private fun createAccountWithFirebase(email :String, password: String){
        setInProgress(true)
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener{
                setInProgress(false)
                Toast.makeText(applicationContext,"User created successfully", Toast.LENGTH_SHORT).show()
                finish()
            }.addOnFailureListener{
                setInProgress(false)
                Toast.makeText(applicationContext,"Create account failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setInProgress(inProgress : Boolean){
        if(inProgress){
            binding.createAccountBtn.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.createAccountBtn.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }


}