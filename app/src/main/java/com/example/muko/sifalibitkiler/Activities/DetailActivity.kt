package com.example.muko.sifalibitkiler.Activities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import com.example.muko.sifalibitkiler.Pojo.Plants
import com.example.muko.sifalibitkiler.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intent = intent
        var detailimg = intent.extras.get("bigImage")
        var detailtitle = intent.extras.get("title")
        var detailexplanation = intent.extras.get("explanation")


        imgPlantsDetail.setImageResource(detailimg as Int)
        tvDetail.setText(detailexplanation as String)

        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        var bitmap : Bitmap = BitmapFactory.decodeResource(resources, detailimg)

        Palette.from(bitmap).generate(object  : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette) {
                var color = palette?.getDarkVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color!!)
                window.statusBarColor = color

            }
        })

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
