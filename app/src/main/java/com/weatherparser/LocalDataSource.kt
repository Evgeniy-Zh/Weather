package com.weatherparser

import com.weatherparser.data.WeatherData
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmChangeListener

/**
 * Created on 19.02.2019.
 */
class LocalDataSource private constructor(var realm: Realm) {

    companion object {
        private var INSTANCE: LocalDataSource? = null
        fun getInstance(realm: Realm): LocalDataSource {
            if (INSTANCE == null)
                INSTANCE = LocalDataSource(realm)
            return INSTANCE as LocalDataSource
        }
    }

    fun saveWeather(weatherData: WeatherData) {
        realm.executeTransactionAsync {
            it.copyToRealmOrUpdate(weatherData)
        }
    }

    fun getWeather(lat: Float, lon: Float): Observable<WeatherData> = Observable.create {
        realm.where(WeatherData::class.java)
            .equalTo("location", "%.3f".format(lat)+"%.3f".format(lon))
            .findFirstAsync()
            .addChangeListener<WeatherData>(RealmChangeListener(fun(data: WeatherData) {
                if (data.isValid && data.timeStamp > System.currentTimeMillis() - 1000*60*60) {
                    it.onNext(data)
                }
                it.onComplete()
            }))


    }

}