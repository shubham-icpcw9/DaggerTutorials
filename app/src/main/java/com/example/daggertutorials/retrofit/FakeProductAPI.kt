package com.example.daggertutorials.retrofit

import com.example.daggertutorials.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakeProductAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Products>>
}