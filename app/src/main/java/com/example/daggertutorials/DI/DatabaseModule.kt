package com.example.daggertutorials.DI

import android.content.Context
import androidx.room.Room
import com.example.daggertutorials.DB.ProductsDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getProductsDB(context : Context) : ProductsDB {
        return Room.databaseBuilder(context, ProductsDB::class.java, "ProductsDB").build()
    }
}