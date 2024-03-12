package com.nareshittechnologies.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val b:Button = view.findViewById(R.id.first_btn)
        b.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_firstFragment)
        }

        val b1:Button = view.findViewById(R.id.second_btn)
        b1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_secondFragment)
        }

        val b2:Button = view.findViewById(R.id.third_btn)
        b2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_thirdFragment)
        }

        return view
    }

}