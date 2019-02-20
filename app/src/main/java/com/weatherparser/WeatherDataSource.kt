package com.weatherparser

import android.util.Log
import com.weatherparser.data.WeatherData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.ResponseBody
import java.io.IOException


/**
 * Created on 18.02.2019.
 */

object WeatherDataSource {

    private val okHttpClient: OkHttpClient

    private val retrofit: Retrofit

    private val apiInterface: ApiInterface

    init {
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(LogJsonInterceptor())
            .build()
        retrofit = Retrofit.Builder().baseUrl("https://api.weather.yandex.ru/v1/informers/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)

    }

    fun getWeather(lat:Float, lon:Float): Observable<WeatherData> {
       return apiInterface.getWeather(
           "1b041130-aadf-4468-825c-7278404115d8",
           lat,
           lon,
           4,
           true)
           .map {
               it.location = "%.3f".format(lat)+"%.3f".format(lon)
               it.timeStamp=System.currentTimeMillis()
               return@map it
           }
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
    }


    class LogJsonInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            val response = chain.proceed(request)
            val rawJson = response.body()!!.string()

            try {
                Log.d(BuildConfig.APPLICATION_ID, String.format("raw JSON response is: %s", rawJson))
            } catch (e: Exception) {
                println(String.format("raw JSON response is: %s", rawJson))
            }
            // Re-create the response before returning it because body can be read only once
            return response.newBuilder()
                .body(ResponseBody.create(response.body()!!.contentType(), rawJson)).build()
        }
    }
}