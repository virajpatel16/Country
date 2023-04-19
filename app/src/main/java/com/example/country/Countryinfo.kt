package com.example.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.country.databinding.ActivityCountryinfoBinding

class Countryinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityCountryinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var pos=intent.getIntExtra("next",0)
        var model=MainActivity.countrylist.get(pos)

        Glide.with(this).load(model.flags?.png).into(binding.dflags)
        binding.dname.text=model.name
        binding.dtopLevelDomain.text=model.topLevelDomain.toString()
        binding.dcallingCodes.text=model.callingCodes.toString()
        binding.dcapital.text=model.capital.toString()
        binding.dresion.text=model.region
        binding.ddemonym.text=model.demonym
        binding.darea.text=model.area.toString()
        binding.dtimezone.text=model.timezones.toString()
        binding.dalpha2Code.text=model.alpha2Code.toString()
        binding.dalpha3Code.text=model.alpha3Code.toString()
        binding.daltSpellings.text=model.altSpellings.toString()
        binding.dsubregion.text=model.subregion
        binding.dpopulation.text=model.population.toString()
        binding.dlatlng.text=model.latlng.toString()
        binding.dnativeName.text=model.nativeName
        binding.dnumericCode.text=model.numericCode.toString()
        binding.dcurrencies.text=model.currencies.toString()
        binding.dcioc.text=model.cioc
        binding.dlanguages.text=model.languages.toString()
        binding.dborders.text=model.borders.toString()


    }
}