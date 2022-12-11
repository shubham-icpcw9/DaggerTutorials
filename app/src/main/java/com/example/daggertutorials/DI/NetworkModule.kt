package com.example.daggertutorials.DI

import com.example.daggertutorials.retrofit.FakeProductAPI
import com.example.daggertutorials.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getFakerAPI(retrofit: Retrofit) : FakeProductAPI{
        return retrofit.create(FakeProductAPI::class.java)
    }

}