package com.doseyenc.weatherapp.network

import com.doseyenc.weatherapp.response.weatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface WeatherDAOInterface {
   @GET("getWeather?data.lang=tr&data.city=nevşehir")
   @Headers("authorization: apikey **********","content-type: application/json")
   fun getWeather(): Call<weatherResponse>

}
