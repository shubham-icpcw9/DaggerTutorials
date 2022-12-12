package com.example.daggertutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.daggertutorials.VM.ProductsVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var productsVM: ProductsVM

    private val products : TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productsVM = ViewModelProvider(this)[ProductsVM::class.java]

        productsVM.productsLiveData.observe(this) {
            products.text = it.joinToString(separator = "\n\n\n") { products -> products.title}
        }
    }
}