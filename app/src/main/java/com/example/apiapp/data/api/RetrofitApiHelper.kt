package com.example.apiapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiHelper {

        var retrofit: Retrofit? = null

        fun init() {
            var logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            var client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
}