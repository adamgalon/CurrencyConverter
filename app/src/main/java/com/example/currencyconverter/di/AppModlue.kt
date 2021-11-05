package com.example.currencyconverter.di


import com.example.currencyconverter.data.CurrencyApi
import com.example.currencyconverter.utlis.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import javax.inject.Singleton
//
//@Module
//@InstallIn()
//object AppModlue {
//    @Singleton
//    @Provides
//    fun provideCurrencyApi(): CurrencyApi {
//        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
//
//    }
//}