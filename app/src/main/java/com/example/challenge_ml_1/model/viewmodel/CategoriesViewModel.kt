package com.example.challenge_ml_1.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_ml_1.model.`object`.Categories
import com.example.challenge_ml_1.model.repo.CategoriesRepo

class CategoriesViewModel : ViewModel() {

    val liveDataCategories =  MutableLiveData<List<Categories>>()

    val liveDataCategorieItem =  MutableLiveData<Categories>()

    fun getCategories ( ) {
        CategoriesRepo () . getCategories( liveDataCategories )
    }


}