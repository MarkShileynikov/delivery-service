package com.example.deliveryservice.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryservice.R
import com.example.deliveryservice.database.entity.Restaurant

class RestaurantAdapter(
    private val restaurants: List<Restaurant>, private val onClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurants[position], onClick)
    }

    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val picture: ImageView = itemView.findViewById(R.id.restaurantPicture)
        private val name: TextView = itemView.findViewById(R.id.restaurantName)

        fun bind(restaurant: Restaurant, onClick: (Restaurant) -> Unit) {
            this.picture.setImageResource(restaurant.picture)
            this.name.text = restaurant.name

            itemView.setOnClickListener {
                onClick(restaurant)
            }
        }
    }
}