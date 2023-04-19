package com.example.country

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClint {

    companion object {
        var BASE_URL = "https://restcountries.com/v2/"

        lateinit var retrofit: Retrofit

        fun getcountry(): Retrofit {

retrofit = Retrofit.Builder().baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
            return  retrofit

        }

        }

}