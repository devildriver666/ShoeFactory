package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.fragments.LoginFragmentDirections
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var binding:FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        binding.existingButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToWelcomeFragment())
        }

        binding.newLoginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragment2ToWelcomeFragment())
        }

        return binding.root
    }
}