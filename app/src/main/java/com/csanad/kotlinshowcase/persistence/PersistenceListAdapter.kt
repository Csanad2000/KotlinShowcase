package com.csanad.kotlinshowcase.persistence

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.csanad.kotlinshowcase.R

class PersistenceListAdapter : Adapter<ViewHolder>() {
    var entries: List<Persistence> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return PersistenceHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_persistence, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is PersistenceHolder -> {
                holder.bind(entries[position].entry)
            }
        }
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    inner class PersistenceHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(entry: String) {
            itemView.findViewById<TextView>(R.id.persistence_text).apply {
                text = entry
            }
        }
    }
}