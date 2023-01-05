package com.csanad.kotlinshowcase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.Adapter

class CategoryListAdapter(val categories: ArrayList<String>, private val host: Host) :
    Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return CategoryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is CategoryHolder -> {
                holder.bind(categories[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(category: String) {
            itemView.findViewById<Button>(R.id.category_button).apply {
                text = category
                setOnClickListener {
                    host.OnButtonClicked(category)
                }
            }
        }
    }

    interface Host {
        fun OnButtonClicked(category: String)
    }
}