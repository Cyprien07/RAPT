package com.example.raptfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class InformationsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informations, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            InformationsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}