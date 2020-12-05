package com.example.challenge_ml_1.utilitie.net;


import com.example.challenge_ml_1.model.object.ResponseQuery;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

//
//    /**
//     * Petición GET que retorna la lista de empresas con vStore configurado
//     * @return
//     */
//    @Headers({
//            "api-key: "+Constant.API_KEY,
//            "xrp-application-id: "+Constant.XRP_APPLICATION_ID,
//            "Content-Type: "+Constant.CONTENT_TYPE
//    })
//    @GET(Constant.BUSINESS)
//    Call<List<BusinessDetail>> getBusinessList();


    @GET("sites/MLA/search")
    Call<ResponseQuery> getItems(@Query("q") String aQueryValue );


    @GET("sites/MLA/search")
    Call<ResponseQuery> getItemsWithLimit(@Query("q") String aQueryValue , @Query("limit") String aLimitValue );


    @GET("sites/MLA/search")
    Call<ResponseQuery> getItemsWithOffset(@Query("q") String aQueryValue , @Query("offset") String aOffsetValue );


    @GET("sites/MLA/search")
    Call<ResponseQuery> getItemsWithLimitAndOffset(@Query("q") String aQueryValue , @Query("limit") String aLimitValue , @Query("offset") String aOffsetValue);

}
