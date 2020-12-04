package com.example.challenge_ml_1

import androidx.lifecycle.ViewModel


class ItemsAndSearchViewModel : ViewModel() {

    fun getItems ( aSearchValue : String ) {
        ItemsAndSearchRepo () . getItems( aSearchValue )
    }


}