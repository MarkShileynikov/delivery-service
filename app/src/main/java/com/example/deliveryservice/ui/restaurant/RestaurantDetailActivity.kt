package com.example.deliveryservice.ui.restaurant

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.deliveryservice.R
import com.example.deliveryservice.database.MainDatabase
import com.example.deliveryservice.database.entity.Order
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class RestaurantDetailActivity : AppCompatActivity() {

    private lateinit var restaurantPictureView: ImageView
    private lateinit var restaurantNameView : TextView
    private lateinit var restaurantDescriptionView: TextView
    private lateinit var orderButton: Button
    private lateinit var db: MainDatabase
    private var userId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        userId = intent.getIntExtra("USER_ID", 0)

        db = MainDatabase.getInstance()

        bindViews()
    }

    private fun bindViews() {
        val restaurantPicture = intent.getIntExtra("RESTAURANT_PICTURE", 0)
        val restaurantName = intent.getStringExtra("RESTAURANT_NAME") ?: ""
        val restaurantDescription = intent.getStringExtra("RESTAURANT_DESCRIPTION") ?: ""

        restaurantPictureView = findViewById(R.id.picture)
        restaurantNameView = findViewById(R.id.restaurantName)
        restaurantDescriptionView = findViewById(R.id.description)
        orderButton = findViewById(R.id.order)

        restaurantPictureView.setImageResource(restaurantPicture)
        restaurantNameView.text = restaurantName
        restaurantDescriptionView.text = restaurantDescription

        orderButton.setOnClickListener {
            val currentDate = LocalDate.now()
            val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            val formattedDate = currentDate.format(dateFormatter)

            val currentTime = LocalTime.now()
            val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
            val formattedTime = currentTime.format(timeFormatter)

            val orderDao = db.getOrderDao()
            orderDao.addOrder(
                Order(
                    restaurantName = restaurantName,
                    userId = userId,
                    date = "$formattedDate $formattedTime"
                )
            )

            Toast.makeText(this, "Заказ оформлен!" , Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}