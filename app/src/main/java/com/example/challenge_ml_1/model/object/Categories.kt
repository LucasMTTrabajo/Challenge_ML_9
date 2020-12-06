package com.example.challenge_ml_1.model.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Categories ( @SerializedName("id") @Expose val id : String ) : Serializable {

    @SerializedName("name")
    @Expose
    val name : String? = null


    override fun toString(): String {
        return "Categories(    \n " +
                "id   = $id    \n," +
                "name = $name  \n " +
                ")"
    }
}