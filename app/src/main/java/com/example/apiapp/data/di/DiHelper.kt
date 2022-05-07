package com.example.apiapp.data.di

import com.example.apiapp.data.IDataSource
import com.example.apiapp.data.api.RetrofitApiHelper
import com.example.apiapp.data.TestApiService
import com.example.apiapp.data.ui.MainContract
import com.example.apiapp.data.ui.MainPresenter

class DiHelper {

  companion object {

      private var mainPresenter: MainContract.Presenter? = null
      private var mainService: IDataSource? = null
      private var retrofitHelper: RetrofitApiHelper? = null

      fun getPresenter(view: MainContract.View): MainContract.Presenter {
          if (mainPresenter == null){
              mainPresenter = MainPresenter(view)
          }

          return mainPresenter!!
      }

      fun getService(): IDataSource {
          if (mainService == null) {
              mainService = TestApiService()
          }

          return mainService!!
      }

      fun getRetrofitHelper(): RetrofitApiHelper {
          if (retrofitHelper == null){
              retrofitHelper = RetrofitApiHelper()
              retrofitHelper?.init()
          }

          return retrofitHelper!!
      }
  }

}