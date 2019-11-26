package com.example.muko.sifalibitkiler.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.muko.sifalibitkiler.Adapter.PlantsAdapter
import com.example.muko.sifalibitkiler.Pojo.Plants
import com.example.muko.sifalibitkiler.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var allPlants = ArrayList<Plants>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allDatas()

        var plantsAdapter = PlantsAdapter(allPlants)
        rv.adapter = plantsAdapter


        var linearLayoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        rv.layoutManager = linearLayoutManager
    }

    private fun allDatas(): ArrayList<Plants> {
        var allImages = arrayOf(
            R.drawable.corekotu,
            R.drawable.adacayi,
            R.drawable.isirganotu,
            R.drawable.zencefil,
            R.drawable.meyankoku,
            R.drawable.aloevera,
            R.drawable.papatya,
            R.drawable.sarimsak,
            R.drawable.nane,
            R.drawable.biberiye,
            R.drawable.maydonoz,
            R.drawable.karabasotu
        )
        var plantsBigImages = arrayOf(
            R.drawable.corekotubuyukres,
            R.drawable.adacayibuyukres,
            R.drawable.isirganotubuyukres,
            R.drawable.zencefilbuyukres,
            R.drawable.meyankokubuyukres,
            R.drawable.aloeverabuyukres,
            R.drawable.papatyabuyukres,
            R.drawable.sarimsakbuyukres,
            R.drawable.nanebuyukres,
            R.drawable.biberiyebuyukres,
            R.drawable.maydonozbuyukres,
            R.drawable.karabasbuyukres)
        var plantsTitle = resources.getStringArray(R.array.plantsTitle)
        var plantsVit = resources.getStringArray(R.array.plantsVit)
        var plantsExplanation = resources.getStringArray(R.array.plantsexplanation)
        for (i in 0..allImages.size - 1) {
            var plants =
                Plants(plantsTitle[i], plantsVit[i],plantsExplanation[i], allImages[i], plantsBigImages[i])
            allPlants.add(plants)
        }
        return allPlants
    }
}
