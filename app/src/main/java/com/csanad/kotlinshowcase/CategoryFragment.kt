package com.csanad.kotlinshowcase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class CategoryFragment : Fragment(), CategoryListAdapter.Host {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false).apply {
            val categories = arrayListOf<String>()
            for (item in resources.getStringArray(R.array.categories)) {
                categories.add(item)
            }
            findViewById<RecyclerView>(R.id.category_list).adapter = CategoryListAdapter(categories, this@CategoryFragment)
        }
    }

    override fun OnButtonClicked(category: String) { //TODO find a better way, less id hardcoding
        val resId = when (category) {
            resources.getStringArray(R.array.categories)[0] -> {
                R.id.action_mainFragment_to_persistenceFragment
            }
            else -> {
                -1
            }
        }
        if (resId != -1)
            findNavController().navigate(resId)
    }
}