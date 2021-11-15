package com.example.currencyconverter.repository

import com.example.currencyconverter.data.CurrencyApi
import com.example.currencyconverter.data.models.BaseDataSource
import com.example.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val api: CurrencyApi) : BaseDataSource() {

    suspend fun getBaseCurrency() {}

}