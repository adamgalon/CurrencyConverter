package com.example.currencyconverter.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.R
import com.example.currencyconverter.data.models.CurrencyResponse
import com.example.currencyconverter.data.models.Data
import com.example.currencyconverter.repository.CurrencyRepository
import com.example.currencyconverter.utlis.Constants
import com.example.currencyconverter.utlis.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.internal.format
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.round


@HiltViewModel
class ConverterViewModel
@Inject constructor(private val currencyRepository: CurrencyRepository) : ViewModel() {

    private val _conversion = MutableLiveData<Resource<String?>>()
    var conversion: LiveData<Resource<String?>> = _conversion


    fun converter(
        fromAmount: String,
        fromCurrency: String,
        toCurrency: String
    ) {





/*        if (fromAmount.isEmpty() && fromAmount != "0") {
            _conversion.postValue(Resource.Error(""))
            return
        }
        val amount = fromAmount.toDouble()

        viewModelScope.launch {
            _conversion.postValue(Resource.Loading())
            when (val response = getBaseCurrency(Constants.API_KEY, fromCurrency)) {
                is Resource.Success -> {
                    val rates = response.data!!.data
                    val rate = getCurrencyRate(toCurrency, rates)
                    val convertedCurrency = amount * rate!!
                    _conversion.value =
                        "$convertedCurrency $toCurrency=$fromAmount $fromCurrency"
                }
                is Resource.Error -> {
                    _conversion.value = response.message
                }
                is Resource.Loading -> {

                }
            }
        }*/
    }


    private fun getCurrencyRate(currency: String, rate: Data) =
        when (currency) {
            "CAD" -> rate.CAD
            "EUR" -> rate.EUR
            "HKD" -> rate.HKD
            "ISK" -> rate.ISK
            "PHP" -> rate.PHP
            "DKK" -> rate.DKK
            "HUF" -> rate.HUF
            "CZK" -> rate.CZK
            "AUD" -> rate.AUD
            "RON" -> rate.RON
            "SEK" -> rate.SEK
            "IDR" -> rate.IDR
            "INR" -> rate.INR
            "BRL" -> rate.BRL
            "RUB" -> rate.RUB
            "HRK" -> rate.HRK
            "JPY" -> rate.JPY
            "THB" -> rate.THB
            "CHF" -> rate.CHF
            "SGD" -> rate.SGD
            "PLN" -> rate.PLN
            "BGN" -> rate.BGN
            "CNY" -> rate.CNY
            "NOK" -> rate.NOK
            "NZD" -> rate.NZD
            "ZAR" -> rate.ZAR
            "USD" -> rate.USD
            "MXN" -> rate.MXN
            "ILS" -> rate.ILS
            "GBP" -> rate.GBP
            "KRW" -> rate.KRW
            "MYR" -> rate.MYR

            else -> null

        }
}


