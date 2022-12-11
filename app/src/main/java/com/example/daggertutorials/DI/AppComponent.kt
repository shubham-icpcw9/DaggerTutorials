package com.example.daggertutorials.DI

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.daggertutorials.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, VmModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface ProductsFactory{
        fun create(@BindsInstance context: Context) : AppComponent
    }

}