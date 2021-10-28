package com.doseyenc.weatherapp.network

import retrofit2.Retrofit

class ApiUtils {
    companion object{
        //
        private const val BASE_URL="https://api.collectapi.com/weather/"

        fun weatherDAOInterfaceGetir():WeatherDAOInterface{
            return retrofitClient.getClient(BASE_URL).create(WeatherDAOInterface::class.java)
        }
    }
}