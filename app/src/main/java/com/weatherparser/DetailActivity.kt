package com.weatherparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.weather_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val condition = Conditions.map[intent.getStringExtra("condition")]
        val temperature = intent.getStringExtra("temperature")
        val imageUrl = intent.getStringExtra("image")
        con.text = condition
        temp.text = temperature

        Glide.with(this)
            .load(imageUrl)
            .apply( RequestOptions().override(100, 100).centerCrop())
            .into(icon)
    }
}
