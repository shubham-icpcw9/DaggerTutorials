package com.example.daggertutorials.DI

import android.content.Context
import androidx.room.Room
import com.example.daggertutorials.DB.ProductsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getProductsDB(@ApplicationContext context : Context) : ProductsDB {
        return Room.databaseBuilder(context, ProductsDB::class.java, "ProductsDB").build()
    }
}