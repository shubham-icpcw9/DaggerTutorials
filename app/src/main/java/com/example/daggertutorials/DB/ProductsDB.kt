package com.example.daggertutorials.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggertutorials.model.Products

@Database(entities = [Products::class], version = 1)
abstract class ProductsDB : RoomDatabase() {

    abstract fun getProductsDAO() : ProductsDAO

}