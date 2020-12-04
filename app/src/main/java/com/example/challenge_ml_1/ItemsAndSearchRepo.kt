package com.example.challenge_ml_1

import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val TAG = "ItemsAndSearchRepo"

class ItemsAndSearchRepo {

    fun getItems (aQueryValue : String) {
        try{
            val service = RetrofitClientInstance.getApiService()
            val call = service . getItems( aQueryValue )


            val callback : Callback<ResponseBody> = object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    try{
                        if ( !response.isSuccessful ) {
                            Log.e(TAG, "getItems: onResponse:  Algo salio mal." )
                            return
                        }
                        val responseBody = response.body()!!

                        Log.i(TAG, "getItems: onResponse: responseBody: $responseBody")

                    } catch ( e  : Exception ) {
                        Log.e(TAG, "getItems: onResponse:  e - ", e)
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.e(TAG, "getItems: onFailure: t - ", t )
                }
            }


            call . enqueue( callback )


        } catch ( e : Exception ) {
            Log.e(TAG, "getItems: getBuisnesses: e - ", e)
        }
    }


}