package com.x7.kotlin_retrofit_jsonplaseholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.x7.kotlin_retrofit_jsonplaseholder.model.Post
import com.x7.kotlin_retrofit_jsonplaseholder.R
import com.x7.kotlin_retrofit_jsonplaseholder.model.PostsPhoto

class PostAdapter constructor(
 val context: Context,
 val arrayList: ArrayList<PostsPhoto>
):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false)
        return PostViewHolder(view)

    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
     holder.textView.text="${arrayList.get(position).title}"
        Glide.with(context).load(arrayList.get(position).url).into(holder.imageView)


    }
    override fun getItemCount(): Int =arrayList.size


    class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById(R.id.textviewresp)
        val imageView:ImageView=itemView.findViewById(R.id.imageviewpresp)
    }
}