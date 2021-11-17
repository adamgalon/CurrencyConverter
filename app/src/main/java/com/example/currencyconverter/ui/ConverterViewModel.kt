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
import okhttp3.internal.format
import timber.log.Timber
import java.lang.Exception
import java.lang.Math.round
import javax.inject.Inject


@HiltViewModel
class ConverterViewModel
@Inject constructor(private val currencyRepository: CurrencyRepository) : ViewModel() {

    //Todo: Correct resource class add viewModel for conversion!!
    private val _conversion = MutableLiveData<Resource<CurrencyResponse>>()
    val conversion: LiveData<Resource<CurrencyResponse>> = _conversion


    private val _convertedMoney = MutableLiveData<String>()
    val convertedMoney: LiveData<String> = _convertedMoney

    fun convert(
        amountStr: String,
        fromCurrency: String,
        toCurrency: String
    ) {
        val fromAmount = amountStr.toFloatOrNull()
        if (fromAmount == null) {
            _conversion.value = Resource.Error("Your amount must not be null or 0")
            return
        }
        //Todo: Correct resource class | or different way to convert data
        viewModelScope.launch {
            _conversion.value = Resource.Loading()
            when (val ratesResponse =
                currencyRepository.getBaseCurrency(Constants.API_KEY, fromCurrency)) {
                is Resource.Error -> _conversion.value =
                    Resource.Error(ratesResponse.message!!)
                is Resource.Success -> {
                    val rates = ratesResponse.data!!.data
                    val rate = getCurrencyRate(toCurrency, rates)
                    if (rate == null) {
                        _conversion.value = Resource.Error("Unexpected error")
                    } else {
                        val convertedCurrency = fromAmount * rate
                        _convertedMoney.value =
                            "$fromAmount $fromCurrency = ${
                                format(
                                    "%,.2f",
                                    convertedCurrency
                                )
                            } $toCurrency"
                    }
                }
            }
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
