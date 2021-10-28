package com.doseyenc.weatherapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.doseyenc.weatherapp.databinding.ActivityMainBinding
import com.doseyenc.weatherapp.model.Weather
import com.doseyenc.weatherapp.network.ApiUtils
import com.doseyenc.weatherapp.response.weatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var weatherList :ArrayList<Weather> = arrayListOf()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        checkTime()
        getWeather()
        setContentView(binding.root)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun checkTime() {
        val currentDateTime = LocalDateTime.now()
        val time = currentDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
      println( time.toString())
    }

    private fun getWeather(){
        ApiUtils.weatherDAOInterfaceGetir().getWeather().enqueue(
            object :Callback<weatherResponse> {
                override fun onResponse(
                    call: Call<weatherResponse>,
                    response: Response<weatherResponse>
                ) {
                    val tempList = response.body()?.result
                    tempList?.let {
                        weatherList = it as ArrayList<Weather>
                    }
                    val weatherAdapter = weatherAdapter(weatherList)
                    binding.weatherRV.adapter = weatherAdapter
                    binding.weatherRV.layoutManager =
                        LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
                    binding.weatherRV.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<weatherResponse>, t: Throwable) {}
            }
        )

        }
    }
