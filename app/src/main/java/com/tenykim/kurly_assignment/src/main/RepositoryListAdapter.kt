package com.tenykim.kurly_assignment.src.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.tenykim.kurly_assignment.R
import values.Item

class RepositoryListAdapter(val repositoryList: MutableList<Item>) : RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    private val TAG = "RepositoryListAdapter_MJ"
    var repName = ""
    var owner = ""
    var url = ""

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindInfo(data: Item) {
            val title = itemView.findViewById<TextView>(R.id.title)
            val owner = itemView.findViewById<TextView>(R.id.owner)
            val url = itemView.findViewById<TextView>(R.id.url)

            title.text = data.full_name
            owner.text = data.owner.login
            url.text = data.url

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "${data.full_name} clicked.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "${repositoryList[position]}")

        holder.bindInfo(repositoryList[position])
    }

    override fun getItemCount(): Int {

        return repositoryList.size
    }
}