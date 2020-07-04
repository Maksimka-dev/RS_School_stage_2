package com.example.rs_school_task_4.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rs_school_task_4.DB.Table
import com.example.rs_school_task_4.R

class MyRecyclerViewAdepter : RecyclerView.Adapter<MyViewHolder>(){

    private val item = mutableListOf<Table>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // TODO RecyclerView.NO_POSITION
        RecyclerView.NO_POSITION
        val model = item[position].modelName
        val age = item[position].age.toString()
        val color = item[position].color

        holder.bind(model, age, color)
    }

    fun AddItems(newItems :List<Table>){
        item.addAll(newItems)
        notifyDataSetChanged()
    }

    fun DelAllItem(){
        item.clear()
    }


}

class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    // TODO private
    val carModelName = itemView.findViewById<TextView>(R.id.CarModel)
    val carAge = itemView.findViewById<TextView>(R.id.CarAge)
    val carColor = itemView.findViewById<TextView>(R.id.CarColor)

    fun bind (model :String, age :String, color :String) {

        carModelName.text = model
        carAge.text = age
        carColor.text = color
    }

}