package com.example.daggertutorials.DI

import androidx.lifecycle.ViewModel
import com.example.daggertutorials.VM.ProductsVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * When we have multiple VMs, then no need of VM Factory for every VMs. Only Single VM Factory
 * will works out.
 * Used Multi-bindings to solve this.
 * Dagger will create Map of type (Class<*>, ViewModel) by using @IntoMap annotation.
 **/

@Module
abstract class VmModule {

    @Binds
    @ClassKey(ProductsVM::class)
    @IntoMap
    abstract fun getProductsVM(productsVM: ProductsVM) : ViewModel
}