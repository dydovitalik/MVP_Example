package com.example.apiapp.data

import com.example.apiapp.data.model.Weather

interface IDataSource {
    fun getLocalWeather(callback: WeatherCallback)


    interface WeatherCallback{
        fun onSuccess(weather: Weather)
        fun onFailure()
    }
}