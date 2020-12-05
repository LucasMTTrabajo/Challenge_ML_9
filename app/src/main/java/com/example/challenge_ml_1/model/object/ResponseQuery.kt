package com.example.challenge_ml_1.model.`object`

import com.example.challenge_ml_1.model.`object`.Product
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseQuery ( @SerializedName("query") @Expose val query : String ) {

    @SerializedName("site_id")
    @Expose
    val site_id : String? = null

    @SerializedName("results")
    @Expose
    val results : List<Product>? = null


}