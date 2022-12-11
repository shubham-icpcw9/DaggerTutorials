package com.example.daggertutorials

import android.app.Application
import com.example.daggertutorials.DI.AppComponent
import com.example.daggertutorials.DI.DaggerAppComponent

class FakerProductsApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}