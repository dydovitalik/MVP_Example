package com.example.apiapp.data

import com.example.apiapp.data.api.TestApi
import com.example.apiapp.data.di.DiHelper
import com.example.apiapp.data.model.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestApiService: IDataSource {

    companion object {
        const val SECRET_KEY ="\$2b\$10\$0lBPy9LoWFzXksFcyju8cemLFcJKIJwcngqUBYcERr3b0f5.kPEbS"
    }

    var api: TestApi

    init {
        api = DiHelper.getRetrofitHelper().retrofit!!.create(TestApi::class.java)
    }

    override fun getLocalWeather(callback: IDataSource.WeatherCallback) {
        api.getLocalWeather(SECRET_KEY).enqueue(object :
            Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.code() == 200 && response.body() != null)
                    callback.onSuccess(response.body()!!)
                else
                    callback.onFailure()
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}