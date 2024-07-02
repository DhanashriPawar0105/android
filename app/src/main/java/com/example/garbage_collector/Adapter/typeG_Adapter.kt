package com.example.garbage_collector.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.garbage_collector.Model.typeG_Model
import com.example.garbage_collector.databinding.TypegItemRecycleRowBinding

class TypeGAdapter(private val typeList: List<typeG_Model>) : RecyclerView.Adapter<TypeGAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: TypegItemRecycleRowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SuspiciousIndentation")
        fun bindData(typeGModel: typeG_Model) {
            binding.textview1.text = typeGModel.name
            Glide.with(binding.imagev).load(typeGModel.image)
                .apply(
                    RequestOptions().transform(RoundedCorners(70))
                )
                .into(binding.imagev)


          //  val context = binding.root.context


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = TypegItemRecycleRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(typeList[position])
    }

    override fun getItemCount(): Int {
        return typeList.size
    }
}
