package com.example.globoplay_desafio_mobile.ui.my_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.globoplay_desafio_mobile.R

class MyListFragment : Fragment() {

//    private lateinit var myListViewModel: MyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_my_list, container, false)

        val textView: TextView = root.findViewById(R.id.text_my_list)

        textView.text = "putz"

        return root
    }
}