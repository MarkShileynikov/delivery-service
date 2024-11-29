package com.example.deliveryservice.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deliveryservice.database.entity.Order

@Dao
interface OrderDao {

    @Query("SELECT * FROM orders WHERE user_id = :userId")
    fun getOrders(userId: Int) : MutableList<Order>

    @Query("DELETE FROM orders WHERE id = :orderId")
    fun deleteOrder(orderId: Int)

    @Insert
    fun addOrder(order: Order)
}