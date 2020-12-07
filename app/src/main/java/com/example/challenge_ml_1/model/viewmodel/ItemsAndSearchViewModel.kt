package com.example.challenge_ml_1.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_ml_1.model.`object`.Product
import com.example.challenge_ml_1.model.repo.ItemsAndSearchRepo


class ItemsAndSearchViewModel : ViewModel() {

    val liveDataProductItems = MutableLiveData<List<Product>>()

    val liveDataProductItem =  MutableLiveData<Product>()

    /**
     * Consigue en la API los productos coincidentes con el query que se pasa por paramtero.
     * El resultaddo conseguido se seteara en el 'liveDataProductItems'.
     *
     * @param aSearchValue: Nombre del producto que se desea buscar en la API.
     */
    fun getItems ( aSearchValue : String ) {
        ItemsAndSearchRepo () . getItems( aSearchValue , liveDataProductItems )
    }


}