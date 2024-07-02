package com.example.garbage_collector

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.garbage_collector.Adapter.TypeGAdapter
import com.example.garbage_collector.Model.typeG_Model
import com.example.garbage_collector.databinding.ActivityTypegBinding
import com.google.firebase.firestore.FirebaseFirestore


class typeG : AppCompatActivity() {
  private lateinit var binding: ActivityTypegBinding
  private lateinit var typegAdapter: TypeGAdapter

   @SuppressLint("WrongViewCast", "MissingInflatedId")
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       enableEdgeToEdge()
       setContentView(R.layout.activity_typeg)
       binding = ActivityTypegBinding.inflate(layoutInflater)
       setContentView(binding.root)
        gettypeg()


   }
  private fun gettypeg() {
       FirebaseFirestore.getInstance().collection("typeg")
           .get().addOnSuccessListener {
               val typeList = it.toObjects(typeG_Model::class.java)
               setUptypeRecyclerView(typeList)

           }


   }

   private fun setUptypeRecyclerView(typeList: List<typeG_Model>) {
       Log.d("Adapter", "Setting up adapter with ${typeList.size} typeg")
       typegAdapter = TypeGAdapter(typeList)
       binding.typegRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
       binding.typegRecyclerView.adapter = typegAdapter


   }


}




