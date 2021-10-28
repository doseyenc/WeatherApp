package com.doseyenc.weatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitClient {
    companion object{
        fun getClient(baseUrl:String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}