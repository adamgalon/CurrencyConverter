package com.example.currencyconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.utlis.Constants
import com.example.currencyconverter.utlis.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ConverterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnConvert.setOnClickListener {
            viewModel.convert(
                binding.tietAmount.text.toString(),
                binding.spFromCurrency.selectedItem.toString(),
                binding.spToCurrency.selectedItem.toString(),
            )
        }

        viewModel.convertedMoney.observe(this, Observer { result ->
            binding.tilResult.text = result
        })

    }
}
