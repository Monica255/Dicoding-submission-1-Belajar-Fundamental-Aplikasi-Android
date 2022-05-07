package com.example.aplikasigit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter(private val listUser:ArrayList<User>):RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView=itemView.findViewById(R.id.img_avatar)
        var tvName: TextView=itemView.findViewById(R.id.tv_name)
        var tvUsername: TextView=itemView.findViewById(R.id.tv_username)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name,_,_,_,_,_, avatar) = listUser[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvUsername.text = "@"+username
        holder.tvName.text = name

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int =listUser.size
    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}