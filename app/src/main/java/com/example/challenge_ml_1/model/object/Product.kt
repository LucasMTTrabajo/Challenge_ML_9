package com.example.challenge_ml_1.model.`object`

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Product ( @SerializedName("id") @Expose val id : String ) : Serializable {

    @SerializedName("site_id")
    @Expose
    val site_id : String? = null

    @SerializedName("title")
    @Expose
    val title : String? = null

    @SerializedName("price")
    @Expose
    val price : Double? = null

    @SerializedName("available_quantity")
    @Expose
    val available_quantity : Int? = null

    @SerializedName("thumbnail")
    @Expose
    val thumbnail : String? = null

    @SerializedName("category_id")
    @Expose
    val category_id : String? = null

    @SerializedName("official_store_id")
    @Expose
    val official_store_id : Int? = null

    @SerializedName("catalog_product_id")
    @Expose
    val catalog_product_id : String? = null

    @SerializedName("attributes")
    @Expose
    val attributes : List<Attributes>? = null






    override fun toString(): String {
        return "Product(                                               \n" +
                "id                       =  $id,                   \n " +
                "site_id                  =  $site_id               \n , " +
                "title                    =  $title                 \n , " +
                "price                    =  $price                 \n , " +
                "available_quantity       =  $available_quantity    \n , " +
                "thumbnail                =  $thumbnail             \n , " +
                "category_id              =  $category_id           \n , " +
                "official_store_id        =  $official_store_id     \n , " +
                "catalog_product_id       =  $catalog_product_id    \n " +
                "attributes               =  $attributes            \n " +
                ")"
    }


}