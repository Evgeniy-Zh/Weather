package com.weatherparser

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.weatherparser.data.Forecast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyRecyclerAdapter

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerAdapter()
        recyclerView.adapter = adapter

        Realm.init(applicationContext)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)


        val localDataSource = LocalDataSource.getInstance(Realm.getDefaultInstance())
        val weatherDataSource = WeatherDataSource

        adapter.listener = object : MyRecyclerAdapter.ItemClickListener {
            override fun onItemClick(pos: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("condition", adapter.list[pos].hours[10]?.condition)
                val temp = adapter.list[pos].hours[10]?.temp
                intent.putExtra("temperature", "" + temp)
                intent.putExtra(
                    "image",
                    if (temp!! <= 0) "https://hikingartist.files.wordpress.com/2012/05/1-christmas-tree.jpg"
                    else "https://openclipart.org/image/2400px/svg_to_png/263892/Colorful-Natural-Tree.png"
                )
                startActivity(intent)

            }

            override fun onItemLongClick(pos: Int) {
            }
        }
        localDataSource.getWeather(47.222531f, 39.718705f)
            .switchIfEmpty(
                weatherDataSource.getWeather(47.222531f, 39.718705f)
                    .doOnNext { localDataSource.saveWeather(it) })
            .doOnSubscribe { loading_view.visibility = View.VISIBLE }
            .doOnNext { loading_view.visibility = View.GONE }
            .subscribe {
                adapter.list = it.forecasts
            }


    }
}
