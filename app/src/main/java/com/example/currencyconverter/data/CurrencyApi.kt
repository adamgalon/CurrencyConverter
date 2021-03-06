package com.example.currencyconverter.data

import com.example.currencyconverter.data.models.CurrencyResponse
import com.example.currencyconverter.utlis.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApi {
    @GET("api/v2/latest")
    suspend fun getBaseCurrency(
        @Query("apikey")
        apiKey: String = Constants.API_KEY,
        @Query("base_currency")
        base: String = "PLN"
    ): Response<CurrencyResponse>
}

//https://freecurrencyapi.net/api/v2/latest?apikey=bea828d0-3d80-11ec-946c-65c45215b926&base_currency=USD
//@GET("api/v2/latest")
//suspend fun getLatestCurrency(
//    @Query("apikey")
//    apiKey: String = Constants.API_KEY,
//): Response<CurrencyResponse>
