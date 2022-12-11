package com.example.daggertutorials.Repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggertutorials.DB.ProductsDB
import com.example.daggertutorials.model.Products
import com.example.daggertutorials.retrofit.FakeProductAPI
import com.example.daggertutorials.utils.NetworkUtils
import javax.inject.Inject

class ProductsRepo @Inject constructor(private val fakerAPI: FakeProductAPI,
                                       private val productsDB: ProductsDB,
                                       private val context : Context
) {

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>
        get() = _products

    suspend fun getProducts(){
        if(NetworkUtils.isInternetAvailable(context)) {
            fetchFromRemote()
        } else {
            fetchFromDB()
        }
    }

    private suspend fun fetchFromRemote() {
        val result = fakerAPI.getProducts()
        if(result.isSuccessful && !result.body().isNullOrEmpty()){
            productsDB.getProductsDAO().addProducts(result.body()!!)     // Caching the remote results
            _products.value = result.body()
        }
    }

    private suspend fun fetchFromDB() {
        val result = productsDB.getProductsDAO().getProducts()
        _products.value = result
    }
}