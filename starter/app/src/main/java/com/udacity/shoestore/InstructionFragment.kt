package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding: FragmentInstructionBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        return binding.root
    }
}