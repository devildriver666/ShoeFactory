package com.udacity.shoestore.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShowListViewModel
import timber.log.Timber


class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoeListBinding

    private val viewModel: ShowListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)

        //viewModel = ViewModelProvider(this).get(ShowListViewModel::class.java)
        binding.showListViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoeObject.observe(viewLifecycleOwner,Observer { shoeObject ->
            shoeObject.forEach { item -> updateUI(item) }
        })

//        viewModel.shoeObject.value?.forEach { item ->
//            updateUI(item)
//        }

        binding.addFab.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    private fun updateUI (item : Shoe) {
        val paramsLayout = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        //setting margin
        paramsLayout.setMargins(10, 30, 10, 30)
        //aligning the layout to center of the screen
        paramsLayout.gravity = Gravity.CENTER
        val linearLayout = LinearLayout(this.requireContext())
        linearLayout.layoutParams = paramsLayout
        linearLayout.setBackgroundColor(Color.parseColor("#606060"))
        linearLayout.orientation = LinearLayout.VERTICAL
        binding.linear2.addView(linearLayout)


        var nameTextView = TextView(this.requireContext())
        var companyTextView = TextView(this.requireContext())
        var description = TextView(this.requireContext())
        var size = TextView(this.requireContext())


        nameTextView.text = item.name
        nameTextView.setTextColor(Color.parseColor("#FFFFFF"))
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        companyTextView.text = item.company
        companyTextView.setTextColor(Color.parseColor("#FFFFFF"))
        companyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        description.text = item.description
        description.setTextColor(Color.parseColor("#FFFFFF"))
        description.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        size.text = item.size.toString()
        size.setTextColor(Color.parseColor("#FFFFFF"))
        size.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(20, 20, 20, 20)
        params.gravity = Gravity.LEFT

        nameTextView.layoutParams = params
        companyTextView.layoutParams = params
        description.layoutParams = params
        size.layoutParams = params

        linearLayout.addView(nameTextView)
        linearLayout.addView(companyTextView)
        linearLayout.addView(description)
        linearLayout.addView(size)
    }
}