package com.example.currencyconverter.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.currencyconverter.data.models.Data
import com.example.currencyconverter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ConverterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpClickListeners()
        updateUi()
    }


    private fun setUpClickListeners() {
        binding.btnConvert.setOnClickListener {
            viewModel.converter(
                binding.tietAmount.text.toString(),
                binding.spFromCurrency.selectedItem.toString(),
                binding.spToCurrency.selectedItem.toString()

            )
        }
    }

    private fun updateUi() {
        viewModel.conversion.observe(this, Observer { currency ->
            binding.tilResult.text = currency
        })
    }
}