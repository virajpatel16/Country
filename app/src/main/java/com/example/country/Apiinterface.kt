package com.example.country

import android.telecom.Call
import retrofit2.http.GET


interface Apiinterface {

    @GET("all")
    fun getallcountry():retrofit2.Call<List<Countrymodel>>
}