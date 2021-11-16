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

        viewModel.getCurrency(Constants.API_KEY, "USD")

        viewModel.conversion.observe(this, Observer { results ->
            when (results) {
                is Resource.Success -> {
                    binding.btnConvert.setOnClickListener {
                        binding.tilResult.text = results.data.toString()


                    }

                }
                is Resource.Error -> {

                    val layout = binding.scrollView
                    Snackbar.make(
                        layout,
                        "Something went wrong, try again or check internet connection.",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }
            }
        })
    }
}