package com.thiago.remote.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceApi {

    companion object{
        private const val LOGIN_URL = "https://bank-app-test.herokuapp.com/api/"
    }

    fun getDataService(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(LOGIN_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }
}