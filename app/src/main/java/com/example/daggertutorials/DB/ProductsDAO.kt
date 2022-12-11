package com.example.daggertutorials.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggertutorials.model.Products

@Dao
interface ProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : List<Products>)

    @Query("SELECT * FROM Products")
    suspend fun getProducts() : List<Products>

}