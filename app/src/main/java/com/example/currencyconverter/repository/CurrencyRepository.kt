package com.example.currencyconverter.repository

import com.example.currencyconverter.data.CurrencyApi
import com.example.currencyconverter.utlis.BaseDataSource
import com.example.currencyconverter.data.models.CurrencyResponse
import com.example.currencyconverter.utlis.Resource
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val api: CurrencyApi) : BaseDataSource() {

    suspend fun getBaseCurrency(apiKey: String, base: String): Resource<CurrencyResponse> {
        return getResult { api.getBaseCurrency(apiKey, base) }
    }

}