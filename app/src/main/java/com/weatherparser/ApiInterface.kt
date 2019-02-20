package com.weatherparser

import com.weatherparser.data.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created on 18.02.2019.
 */
interface ApiInterface {

    @GET("https://api.weather.yandex.ru/v1/forecast")
    fun getWeather(
        @Header("X-Yandex-API-Key") apiKey: String,
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("limit") limit:Int,
        @Query("hours") hours: Boolean
    ): Observable<WeatherData>

}