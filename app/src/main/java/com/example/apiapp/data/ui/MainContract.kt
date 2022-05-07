package com.example.apiapp.data.ui

import com.example.apiapp.data.model.Weather

interface MainContract {
      interface View {
          fun displayWeather(weather: Weather)
          fun displayError()
      }

      interface Presenter {
          fun loadData()
      }


}