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
//import com.example.meditation.feel
import com.example.meditation.feelings
import com.example.meditation.quotes


class FeelRecycler (val context: Context, val feelings: feelings) : RecyclerView.Adapter<FeelRecycler.MyVH>() {
    class MyVH(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_feel)
        val title: TextView = itemView.findViewById(R.id.text_feel)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelRecycler.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter,parent,false)
        return MyVH(root)
    }
    override fun onBindViewHolder(holder: MyVH, position: Int) {
        Glide.with(context).load(feelings.data[position].image).into(holder.imageView)
        holder.title.setText(feelings.data[position].title)
    }
    override fun getItemCount(): Int {
        return feelings.data.size
    }
}

//class FeelRecycler(val context: Context, val list: ArrayList<feel>): RecyclerView.Adapter<FeelRecycler.MyVH>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
//        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter,parent,false)
//        return MyVH(root)
//    }
//    class MyVH(ItemView: View): RecyclerView.ViewHolder(ItemView) {
//        val image:ImageView = itemView.findViewById(R.id.img_feel)
//        val textView:TextView = itemView.findViewById(R.id.text_feel)
//    }
//
//    override fun onBindViewHolder(holder: FeelRecycler.MyVH, position: Int) {
//        holder.image.setImageResource(list[position].image)
//        holder.textView.setText(list[position].name_feel)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}


//class FeelRecycler(val context: Context, val list: feelings):
//    RecyclerView.Adapter<FeelRecycler.MyWH>(){
//    class MyWH(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.img_feel)
//        val textView: TextView = itemView.findViewById(R.id.text_feel)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWH {
//        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter,parent,false)
//        return MyWH(root)
//    }
//
//    override fun onBindViewHolder(holder: MyWH, position: Int) {
//        holder.textView.text = list.data[position].title
//        Glide.with(context).load(list.data[position].image).into(holder.imageView)
//    }
//
//    override fun getItemCount(): Int {
//        return list.data.size
//    }
//}