package com.dicoding.android.githubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<MainAdapter.UserViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val (name, username, company, avatar) = users[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvUsername.text = username
        holder.tvCompany.text = company
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(users[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = users.size

    class UserViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}