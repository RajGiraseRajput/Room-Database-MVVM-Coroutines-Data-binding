package com.example.roomdatabasemvvmcoroutinsdatabinding.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasemvvmcoroutinsdatabinding.databinding.PersonItemsBinding
import com.example.roomdatabasemvvmcoroutinsdatabinding.room.PersonModel

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {

    var list = mutableListOf<PersonModel>()
    var setOnItemLongClickListener : ((PersonModel) -> Unit)?= null

    @SuppressLint("NotifyDataSetChanged")
    fun setContentList(list:List<PersonModel>){
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun setOnLongItemClickListener(listener:(PersonModel) -> Unit){
        setOnItemLongClickListener = listener
    }

    inner class MyViewHolder(val viewDataBinding:PersonItemsBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = PersonItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.person = list[position]

        holder.viewDataBinding.root.setOnLongClickListener {
            setOnItemLongClickListener?.let {
                it(list[position])
            }
            return@setOnLongClickListener true
        }
    }
}