package com.doseyenc.weatherapp.response

import com.doseyenc.weatherapp.model.Weather
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class weatherResponse(
    @SerializedName("result") @Expose var result : List<Weather>
)
