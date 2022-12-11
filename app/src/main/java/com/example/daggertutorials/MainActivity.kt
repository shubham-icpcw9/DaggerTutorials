package com.example.daggertutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggertutorials.VM.ProductsVM
import com.example.daggertutorials.VM.ProductsVmFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var productsVM: ProductsVM

    @Inject
    lateinit var productsVmFactory : ProductsVmFactory

    private val products : TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerProductsApp).appComponent.inject(this)

        productsVM = ViewModelProvider(this, productsVmFactory)[ProductsVM::class.java]

        productsVM.productsLiveData.observe(this) {
            products.text = it.joinToString(separator = "\n\n\n") { products -> products.title}
        }
    }
}