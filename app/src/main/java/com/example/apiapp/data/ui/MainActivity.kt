package com.example.apiapp.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.apiapp.R
import com.example.apiapp.data.di.DiHelper
import com.example.apiapp.data.model.*

class MainActivity : AppCompatActivity(), MainContract.View{

    lateinit var locationTv: TextView
    lateinit var temperatureTv: TextView
    lateinit var windTv: TextView

    var presenter: MainContract.Presenter = DiHelper.getPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        locationTv = findViewById(R.id.locationTv)
        temperatureTv = findViewById(R.id.temperatureTv)
        windTv = findViewById(R.id.windTv)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadData()
    }


     override fun displayError(){
        Log.d("API", "error loading data")
        Toast.makeText(MainActivity@ this, "Failed to load data", Toast.LENGTH_LONG).show()
    }

     override fun displayWeather(weather: Weather){
        Log.d("API", "${weather.temperature}")
        Log.d("API", "${weather.location}")
        Log.d("API", "${weather.wind}")

        locationTv.setText("Weather at: ${weather.location?.name}")
        temperatureTv.setText("Temperature: ${weather.temperature} *C")
        windTv.setText("Wind: ${weather.wind?.speed} m/s ${weather.wind?.orientation!!}")
    }
}