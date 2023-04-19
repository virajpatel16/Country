package com.example.country

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.country.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    companion object {

        var countrylist = ArrayList<Countrymodel>()
    }

    lateinit var adepter: CountryAdepter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiinterface = ApiClint.getcountry().create(Apiinterface::class.java)

        apiinterface.getallcountry().enqueue(object : Callback<List<Countrymodel>> {
            override fun onResponse(
                call: Call<List<Countrymodel>>,
                response: Response<List<Countrymodel>>
            ) {


                if (response.isSuccessful) {
                    var countryclik= object : Countryclik {
                        override fun onTap(i: Int) {
                            startActivity(Intent(this@MainActivity, Countryinfo::class.java)
                                    .putExtra("next", i))
                        }
                    }
                    countrylist = response.body() as ArrayList<Countrymodel>
                    adepter = CountryAdepter(countrylist,countryclik)

                    binding.rcvdata.layoutManager=LinearLayoutManager(this@MainActivity)
                    binding.rcvdata.adapter=adepter

                } else {
                    Log.e(TAG, "error the code")
                }
            }


            override fun onFailure(call: Call<List<Countrymodel>>, t: Throwable) {

            }


        })
    }
}