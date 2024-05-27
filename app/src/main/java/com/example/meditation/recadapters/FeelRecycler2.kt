package com.example.meditation.recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meditation.R
import com.example.meditation.quotes

//class FeelRecycler2(val context: Context, val list: ArrayList<state>): RecyclerView.Adapter<FeelRecycler2.MyVH>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
//        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter2,parent,false)
//        return MyVH(root)
//    }
//
//    class MyVH(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val textView2:TextView = itemView.findViewById(R.id.text_feel2)
//        val textView3:TextView = itemView.findViewById(R.id.text_feel3)
//        val image2:ImageView = itemView.findViewById(R.id.img_feel2)
//    }
//
//    override fun onBindViewHolder(holder: MyVH, position: Int) {
//        holder.textView2.setText(list[position].title)
//        holder.textView3.setText(list[position].text_state)
//        holder.image2.setImageResource(list[position].image_state)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}

class FeelRecycler2 (val context: Context, val quotes: quotes) : RecyclerView.Adapter<FeelRecycler2.MyVH>() {
    class MyVH(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_feel2)
        val title: TextView = itemView.findViewById(R.id.text_feel3)
        val text_state: TextView = itemView.findViewById(R.id.text_feel2)
        val button: TextView = itemView.findViewById(R.id.button4)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelRecycler2.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter2,parent,false)
        return MyVH(root)
    }
    override fun onBindViewHolder(holder: MyVH, position: Int) {
        Glide.with(context).load(quotes.data[position].image).into(holder.imageView)
        holder.title.setText(quotes.data[position].title)
        holder.text_state.setText(quotes.data[position].description)
    }
    override fun getItemCount(): Int {
        return quotes.data.size
    }
}