package com.example.daggertutorials.VM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggertutorials.Repo.ProductsRepo
import javax.inject.Inject

class ProductsVmFactory @Inject constructor(private val viewmodelMap : Map<Class<*>,
        @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewmodelMap[modelClass] as T
    }
}