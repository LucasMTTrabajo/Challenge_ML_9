package com.example.challenge_ml_1.model.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.challenge_ml_1.model.`object`.Categories
import com.example.challenge_ml_1.model.`object`.Product
import com.example.challenge_ml_1.model.`object`.ResponseQuery
import com.example.challenge_ml_1.utilitie.net.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "CategoriesRepo"

class CategoriesRepo {


    /**
     * Consigue todas las categorias de la API y lo guarda en el LiveData pasado por parametro.
     *
     * @param aLiveDataCategoriesList: LiveData donde será seteada las categorias conseguidas.
     * En algún lugar este LiveData debe tener un observador.
     */
    fun getCategories ( aLiveDataCategoriesList : MutableLiveData<List<Categories>>) {
        try{
            val service = RetrofitClientInstance.getApiService()
            val call = service . categories

            val callback : Callback<List<Categories>> = object : Callback<List<Categories>> {
                override fun onResponse(call: Call<List<Categories>>, response: Response<List<Categories>>) {
                    try{
                        if ( !response.isSuccessful ) {
                            Log.e(TAG, "getCategories: onResponse:  Algo salio mal." )
                            return
                        }
                        val responseBody = response.body()!!

                        aLiveDataCategoriesList . value = responseBody


                    } catch ( e  : Exception ) {
                        Log.e(TAG, "getCategories: onResponse:  e - ", e)
                    }
                }

                override fun onFailure(call: Call<List<Categories>>, t: Throwable) {
                    Log.e(TAG, "getCategories: onFailure: t - ", t )
                }
            }


            call . enqueue( callback )
        } catch ( e : Exception ) {
            Log.e(TAG, "getCategories: e - ", e)
        }
    }

}