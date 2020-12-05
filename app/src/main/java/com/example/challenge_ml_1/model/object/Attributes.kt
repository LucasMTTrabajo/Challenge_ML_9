package com.example.challenge_ml_1.model.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Attributes (@SerializedName("id") @Expose val id : String) : Serializable{

    @SerializedName("name")
    @Expose
    val name    : String? = null

    @SerializedName("value_id")
    @Expose
    val value_id    : String? = null

    @SerializedName("value_name")
    @Expose
    val value_name  : String? = null

    @SerializedName("attribute_group_id")
    @Expose
    val attribute_group_id  : String? = null


    override fun toString(): String {
        return "Attributes(                                       \n" +
                "id                    =    $id                   \n, " +
                "name                  =    $name                 \n, " +
                "value_id              =    $value_id             \n, " +
                "value_name            =    $value_name           \n, " +
                "attribute_group_id    =    $attribute_group_id   \n" +
                ")"
    }


}