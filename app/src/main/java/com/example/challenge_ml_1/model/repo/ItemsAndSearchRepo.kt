package com.example.challenge_ml_1.model.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.challenge_ml_1.model.`object`.Product
import com.example.challenge_ml_1.model.`object`.ResponseQuery
import com.example.challenge_ml_1.utilitie.net.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "ItemsAndSearchRepo"

class ItemsAndSearchRepo {

    /**
     * Consigue los productos de la API a partir de la query que se le pasa por paramtero y setea los productos conseguidos en
     * el LiveData que se le pasa por parametro.
     * La cantidad de productos conseguidos es menos a 1000. Para conseguir más se necesitan token y etc.
     *
     * @param aQueryValue: Consulta con el nombre del producto que se desea pedir a la API.
     *
     * @param aLiveDataProductsList: LiveData donde será seteada los productos conseguidos.
     * En algún lugar este LiveData debe tener un observador.
     */
    fun getItems (aQueryValue : String , aLiveDataProductsList : MutableLiveData<List<Product>>) {
        try{
            val service = RetrofitClientInstance.getApiService()
            val call = service . getItems( aQueryValue )

            val callback : Callback<ResponseQuery> = object : Callback<ResponseQuery> {
                override fun onResponse(call: Call<ResponseQuery>, response: Response<ResponseQuery>) {
                    try{
                        if ( !response.isSuccessful ) {
                            Log.e(TAG, "getItems: onResponse:  Algo salio mal." )
                            return
                        }
                        val responseBody = response.body()!!

                        aLiveDataProductsList . value = responseBody . results



                    } catch ( e  : Exception ) {
                        Log.e(TAG, "getItems: onResponse:  e - ", e)
                    }
                }

                override fun onFailure(call: Call<ResponseQuery>, t: Throwable) {
                    Log.e(TAG, "getItems: onFailure: t - ", t )
                }
            }


            call . enqueue( callback )


        } catch ( e : Exception ) {
            Log.e(TAG, "getItems: e - ", e)
        }
    }


}