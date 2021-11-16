package com.example.currencyconverter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.data.models.CurrencyResponse
import com.example.currencyconverter.data.models.Data
import com.example.currencyconverter.repository.CurrencyRepository
import com.example.currencyconverter.utlis.Constants
import com.example.currencyconverter.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.round


@HiltViewModel
class ConverterViewModel
@Inject constructor(private val currencyRepository: CurrencyRepository) : ViewModel() {

    private val _conversion = MutableLiveData<Resource<CurrencyResponse>>()
    val conversion: LiveData<Resource<CurrencyResponse>> = _conversion

    fun getCurrency(apiKey: String, base: String) {
        try {
            viewModelScope.launch {
                _conversion.value = currencyRepository.getBaseCurrency(apiKey, base)
            }
        } catch (e: Exception) {
            Timber.d("ViewModel Exception $e")
        }
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