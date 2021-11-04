package com.example.currencyconverter.data.models

data class Query(
    val apikey: String,
    val base_currency: String,
    val timestamp: Int
)