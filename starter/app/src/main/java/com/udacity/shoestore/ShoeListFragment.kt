package com.udacity.shoestore

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    var cards= arrayOf(R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6);
    var shoes= arrayOf("Shoe Value 1","Shoe Value 2","Shoe Value 3","Shoe Value 4","Shoe Value 5","Shoe Value 6");
    var company= arrayOf("Shoe Company 1","Shoe Company 2","Shoe Company 3","Shoe Company 4","Shoe Company 5","Shoe Company 6");
    var description= arrayOf("Shoe description 1","Shoe description 2","Shoe description 3","Shoe description 4","Shoe description 5","Shoe description 6");

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)

        //--

        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        //setting margin
        params.setMargins(10, 30, 10, 30)
        //aligning the layout to center of the screen
        params.gravity = Gravity.CENTER

        for (item in shoes) {
            val linearLayout = LinearLayout(this.requireContext())
            linearLayout.layoutParams = params
            linearLayout.setBackgroundColor(Color.parseColor("#606060"))
            linearLayout.orientation = LinearLayout.VERTICAL
            binding.linear2.addView(linearLayout)


            var nameTextView = TextView(this.requireContext())
            var companyTextView = TextView(this.requireContext())
            var description = TextView(this.requireContext())
            var size = TextView(this.requireContext())


            nameTextView.text = item
            nameTextView.setTextColor(Color.parseColor("#FFFFFF"))
            nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            companyTextView.text = item
            companyTextView.setTextColor(Color.parseColor("#FFFFFF"))
            companyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            description.text = item
            description.setTextColor(Color.parseColor("#FFFFFF"))
            description.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            size.text = item
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

        return binding.root
    }
}