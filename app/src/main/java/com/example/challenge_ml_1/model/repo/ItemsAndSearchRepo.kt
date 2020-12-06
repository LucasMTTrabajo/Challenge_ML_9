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