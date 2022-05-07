package com.example.apiapp.data.ui

import android.util.Log
import com.example.apiapp.data.di.DiHelper
import com.example.apiapp.data.IDataSource
import com.example.apiapp.data.model.Weather

class MainPresenter(val view: MainContract.View): MainContract.Presenter {

    val service: IDataSource = DiHelper.getService()

    override fun loadData() {
        Log.d("API", "loadData")
        service.getLocalWeather(object : IDataSource.WeatherCallback {
            override fun onSuccess(weather: Weather){
                view.displayWeather(weather)
            }

            override fun onFailure(){
                view.displayError()
            }
        })
    }
}