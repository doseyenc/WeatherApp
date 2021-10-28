package com.doseyenc.weatherapp

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.bumptech.glide.Glide
import com.doseyenc.weatherapp.databinding.WeatherCardBinding
import com.doseyenc.weatherapp.model.Weather
import com.squareup.picasso.Picasso
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class weatherAdapter(private var weatherList: ArrayList<Weather>)
    :RecyclerView.Adapter<weatherAdapter.WeatherCardDesign>(){
        class WeatherCardDesign(val weatherCardBinding: WeatherCardBinding)
            :RecyclerView.ViewHolder(weatherCardBinding.root){

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val weatherCardBinding = WeatherCardBinding.inflate(layoutInflater,parent,false)

        return WeatherCardDesign(weatherCardBinding)
    }

    override fun onBindViewHolder(holder: WeatherCardDesign, position: Int) {
        val weather=weatherList[position]
        holder.weatherCardBinding.apply {
            textViewCity.text="Nevşehir"
            textViewDate.text=weather.date
            textViewDay.text=weather.day
            textViewDegree.text=weather.degree.substring(0,weather.degree.indexOf("."))
            textViewHumidity.text="HUMİDİTY: "+weather.humidity
            textViewStatus.text=weather.description
            textViewMax.text="MAX: "+weather.max
            textViewMin.text="MIN: "+weather.min
            //Picasso.get().load(weather.icon).into(imageViewWeather)
            //Glide.with(root).load(weather.icon).into(imageViewWeather)
           //imageViewWeather.load(weather.icon)
            imageViewWeather.loadSvg(weather.icon)

        }
    }

    override fun getItemCount()=weatherList.size



    }


private fun ImageView.loadSvg(url: String) {
    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .crossfade(true)
        .crossfade(500)
        .data(url)
        .target(this)
        .build()

    imageLoader.enqueue(request)

}

