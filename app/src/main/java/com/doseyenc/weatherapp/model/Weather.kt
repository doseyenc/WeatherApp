package com.doseyenc.weatherapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Weather(
    @SerializedName("date") @Expose var date:String,
    @SerializedName("day") @Expose var day:String,
    @SerializedName("icon") @Expose var icon:String,
    @SerializedName("description") @Expose var description:String,
    @SerializedName("status") @Expose var status:String,
    @SerializedName("degree") @Expose var degree:String,
    @SerializedName("min") @Expose var min:String,
    @SerializedName("max") @Expose var max:String,
    @SerializedName("night") @Expose var night:String,
    @SerializedName("humidity") @Expose var humidity:String

):Serializable
