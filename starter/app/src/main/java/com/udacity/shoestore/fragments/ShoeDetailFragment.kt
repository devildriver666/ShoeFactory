package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShowListViewModel
import com.udacity.shoestore.viewmodel.addNewItem
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: ShowListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_detail_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_add) {
            val name = binding.nameText.text.toString()
            val company = binding.companyText.text.toString()
            val size = binding.sizeText.text.toString()
            val description = binding.descriptionText.text.toString()
            if (name.trim().isEmpty()) {
                Toast.makeText(context, "Name Required ", Toast.LENGTH_SHORT).show()
            } else if (company.trim().isEmpty()) {
                Toast.makeText(context, "Company Name Required ", Toast.LENGTH_SHORT).show()
            } else if (size.trim().isEmpty()) {
                Toast.makeText(context, "Size Required ", Toast.LENGTH_SHORT).show()
            } else if (description.trim().isEmpty()) {
                Toast.makeText(context, "Description Required ", Toast.LENGTH_SHORT).show()
            } else {
                //Add To view model
                val shoe = Shoe(name,size.toDouble(),company, description)
                viewModel.shoeObject.addNewItem(shoe)
                findNavController().popBackStack()
            }
        }
        if(item.itemId == R.id.menu_cancel) {
            findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
}