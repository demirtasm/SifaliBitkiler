package com.example.muko.sifalibitkiler.Adapter

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.muko.sifalibitkiler.Activities.DetailActivity
import com.example.muko.sifalibitkiler.Pojo.Plants
import com.example.muko.sifalibitkiler.R
import kotlinx.android.synthetic.main.plantslayoutview.view.*


class PlantsAdapter(allPlants: ArrayList<Plants>) : RecyclerView.Adapter<PlantsAdapter.MyViewHolder>() {

    var plants = allPlants
    lateinit var tumBitkiler: ArrayList<Plants>

    override fun getItemCount(): Int {
        return plants.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var plantslayoutview = inflater.inflate(R.layout.plantslayoutview, parent, false)
        return MyViewHolder(plantslayoutview)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var allPlants = ArrayList<Plants>()
        holder.plantsTitle.text = plants.get(position).title
        holder.plantsVit.text = plants.get(position).vit
        holder.plantsImg.setImageResource(plants.get(position).image)

        holder.itemView.setOnClickListener { v ->
            var intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("title", plants.get(position).title)
            intent.putExtra("explanation", plants.get(position).explanation)
            intent.putExtra("bigImage", plants.get(position).plantsBigImage)
            v.context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var itemViewPlants = itemView as CardView
        var plantsTitle = itemViewPlants.tvTitle
        var plantsVit = itemViewPlants.tvVit
        var plantsImg = itemViewPlants.imgPlants

    }
}