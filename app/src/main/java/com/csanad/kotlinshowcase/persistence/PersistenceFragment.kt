package com.csanad.kotlinshowcase.persistence

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.csanad.kotlinshowcase.R
import com.google.android.material.textfield.TextInputLayout

class PersistenceFragment : Fragment() {
    private val persistenceAdapter = PersistenceListAdapter()
    private lateinit var persistenceList: RecyclerView
    private lateinit var persistenceDatabase: PersistenceDatabase
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_persistence, container, false).also {
            persistenceList = it.findViewById<RecyclerView>(R.id.persistence_list).apply {
                adapter = persistenceAdapter
            }
            editText = it.findViewById<TextInputLayout>(R.id.textInputLayout).editText!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        persistenceDatabase = PersistenceDatabase.getInstance(requireContext())!!.also {
            it.readPersistence().observe(viewLifecycleOwner) {
                persistenceAdapter.entries = it
            }
            view.findViewById<Button>(R.id.persistence_button).setOnClickListener { _ ->
                it.insertPersistence(Persistence(editText.text.toString()))
                editText.text.clear()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }
}