package com.example.challenge_ml_1.utilitie.net;


import com.example.challenge_ml_1.model.object.Categories;
import com.example.challenge_ml_1.model.object.ResponseQuery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    /**
     * GET https://api.mercadolibre.com/sites/MLA/search
     *
     * Busca los producctos en la API a partir de una consulta.
     *
     * @param aQueryValue: Query del producto que se esta buscando.
     * @return
     */
    @GET("sites/MLA/search")
    Call<ResponseQuery> getItems(@Query("q") String aQueryValue );


    /**
     * GET https://api.mercadolibre.com/sites/MLA/search
     *
     * Busca los producctos en la API a partir de una consulta y con una cantidad especifica de produtos.
     *
     * @param aQueryValue: Query del producto que se esta buscando.
     * @param aLimitValue: Limite de productos que se deseaa recibir.
     * @return
     */
    @GET("sites/MLA/search")
    Call<ResponseQuery> getItemsWithLimit(@Query("q") String aQueryValue , @Query("limit") String aLimitValue );


    /**
     * GET https://api.mercadolibre.com/sites/MLA/search
     *
     * Busca los producctos en la API a partir de una consulta y con una cantidad especifica de produtos.
     *
     * @param aQueryValue: Query del producto que se esta buscando.
     * @param aOffsetValue: Offset para la implementacion de paginacion.
     * @return
     */
    @GET("sites/MLA/search")
    Call<ResponseQuery> getItemsWithOffset(@Query("q") String aQueryValue , @Query("offset") String aOffsetValue );


    /**
     * GET https://api.mercadolibre.com/sites/MLA/search
     *
     * Busca los producctos en la API a partir de una consulta y con una cantidad especifica de produto y  offset.
     *
     * @param aQueryValue: Query del producto que se esta buscando.
     * @param aLimitValue: Limite de productos que se deseaa recibir.
     * @param aOffsetValue: Offset para la implementacion de paginacion.
     * @return
     */
    @GET("sites/MLA/search")
    Call<ResponseQuery> getItemsWithLimitAndOffset(@Query("q") String aQueryValue , @Query("limit") String aLimitValue , @Query("offset") String aOffsetValue);


    /**
     * GET https://api.mercadolibre.com/sites/MLA/categories
     *
     * Consigue las categorias disponibles.
     *
     * @return
     */
    @GET("sites/MLA/categories")
    Call<List<Categories>> getCategories();


}
