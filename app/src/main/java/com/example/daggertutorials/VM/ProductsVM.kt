package com.example.daggertutorials.VM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggertutorials.Repo.ProductsRepo
import com.example.daggertutorials.model.Products
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductsVM @Inject constructor(private val repository: ProductsRepo) : ViewModel() {

    val productsLiveData : LiveData<List<Products>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}