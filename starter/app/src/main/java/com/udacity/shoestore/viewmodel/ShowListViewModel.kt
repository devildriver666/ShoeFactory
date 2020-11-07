package com.udacity.shoestore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShowListViewModel : ViewModel() {

    private var _shoeObject = MutableLiveData<MutableList<Shoe>>()
    var shoeObject : MutableLiveData<MutableList<Shoe>>
        get() = _shoeObject

    init {
        _shoeObject.value = mutableListOf<Shoe>()
        prepareInitialList()
        shoeObject = _shoeObject
    }


    private fun prepareInitialList() {

        val shoe1 = Shoe("Shoe Value 1",10.0,"Shoe Company 1", "Shoe Description 1")
        val shoe2 = Shoe("Shoe Value 2",11.0,"Shoe Company 2", "Shoe Description 2")
        val shoe3 = Shoe("Shoe Value 3",12.0,"Shoe Company 3", "Shoe Description 3")
        val shoe4 = Shoe("Shoe Value 4",13.0,"Shoe Company 4", "Shoe Description 4")
        val shoe5 = Shoe("Shoe Value 5",9.0,"Shoe Company 5", "Shoe Description 5")
        val shoe6 = Shoe("Shoe Value 6",8.0,"Shoe Company 6", "Shoe Description 6")
        val shoe7 = Shoe("Shoe Value 7",7.0,"Shoe Company 7", "Shoe Description 7")

        _shoeObject.value?.add(shoe1)
        _shoeObject.value?.add(shoe2)
        _shoeObject.value?.add(shoe3)
        _shoeObject.value?.add(shoe4)
        _shoeObject.value?.add(shoe5)
        _shoeObject.value?.add(shoe6)
        _shoeObject.value?.add(shoe7)
    }
}

fun <T> MutableLiveData<MutableList<T>>.addNewItem(item: T) {
    val oldValue = this.value ?: mutableListOf()
    oldValue.add(item)
    this.value = oldValue
}