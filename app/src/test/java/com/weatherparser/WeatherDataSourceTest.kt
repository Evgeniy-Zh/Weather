package com.weatherparser

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

/**
 * Created on 18.02.2019.
 */
class WeatherDataSourceTest {

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {  Schedulers.trampoline() }
    }

    @Test
    fun getWeather() {
        val weatherDataSource = WeatherDataSource
        val data = weatherDataSource.getWeather(47.22253f, 39.718705f).blockingFirst()
        println(data.info.tzinfo.name)
        data.forecasts.forEach{ println(it.date)}
        data.forecasts.forEach{list -> list.hours.forEach { println(it) }}
        println(data.location)
    }
}