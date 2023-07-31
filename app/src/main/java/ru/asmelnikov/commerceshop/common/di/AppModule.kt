package ru.asmelnikov.commerceshop.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.asmelnikov.commerceshop.data.datasources.CartDataSource
import ru.asmelnikov.commerceshop.data.datasources.CategoryDataSource
import ru.asmelnikov.commerceshop.data.datasources.PaymentDataSource
import ru.asmelnikov.commerceshop.data.datasources.ProductDataSource
import ru.asmelnikov.commerceshop.data.datasources.mock.CartMocked
import ru.asmelnikov.commerceshop.data.datasources.mock.CategoryMocked
import ru.asmelnikov.commerceshop.data.datasources.mock.PaymentMocked
import ru.asmelnikov.commerceshop.data.datasources.mock.ProductMocked
import ru.asmelnikov.commerceshop.data.repository.CartRepositoryImpl
import ru.asmelnikov.commerceshop.data.repository.CategoryRepositoryImpl
import ru.asmelnikov.commerceshop.data.repository.PaymentRepositoryImpl
import ru.asmelnikov.commerceshop.data.repository.ProductRepositoryImpl
import ru.asmelnikov.commerceshop.domain.repository.CartRepository
import ru.asmelnikov.commerceshop.domain.repository.CategoryRepository
import ru.asmelnikov.commerceshop.domain.repository.PaymentRepository
import ru.asmelnikov.commerceshop.domain.repository.ProductRepository
import ru.asmelnikov.commerceshop.domain.usecases.cart.*
import ru.asmelnikov.commerceshop.domain.usecases.payment.DoPayment
import ru.asmelnikov.commerceshop.domain.usecases.payment.PaymentUseCases
import ru.asmelnikov.commerceshop.domain.usecases.product.GetCategoryList
import ru.asmelnikov.commerceshop.domain.usecases.product.GetProductDetail
import ru.asmelnikov.commerceshop.domain.usecases.product.GetProductList
import ru.asmelnikov.commerceshop.domain.usecases.product.ProductUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductDataSource(): ProductDataSource {
        return ProductMocked()
    }

    @Provides
    @Singleton
    fun provideCategoryDataSource(): CategoryDataSource {
        return CategoryMocked()
    }

    @Provides
    @Singleton
    fun provideCartProductDataSource(): CartDataSource {
        return CartMocked()
    }

    @Provides
    @Singleton
    fun providePaymentDataSource(): PaymentDataSource {
        return PaymentMocked()
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        productDataSource: ProductDataSource,
    ): ProductRepository {
        return ProductRepositoryImpl(productDataSource)
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(
        categoryDataSource: CategoryDataSource,
    ): CategoryRepository {
        return CategoryRepositoryImpl(categoryDataSource)
    }

    @Provides
    @Singleton
    fun provideCartRepository(
        cartDataSource: CartDataSource,
    ): CartRepository {
        return CartRepositoryImpl(cartDataSource)
    }

    @Provides
    @Singleton
    fun providePaymentRepository(
        paymentDataSource: PaymentDataSource,
    ): PaymentRepository {
        return PaymentRepositoryImpl(paymentDataSource)
    }

    @Provides
    @Singleton
    fun provideProductUseCases(
        productRepository: ProductRepository,
        categoryRepository: CategoryRepository,
    ): ProductUseCases {
        return ProductUseCases(
            getProducts = GetProductList(productRepository),
            getProduct = GetProductDetail(productRepository),
            getCategories = GetCategoryList(categoryRepository)
        )
    }

    @Provides
    @Singleton
    fun provideCartUseCases(
        cartRepository: CartRepository,
    ): CartUseCases {
        return CartUseCases(
            saveItemCart = SaveItemCart(cartRepository),
            removeItemCart = RemoveItemCart(cartRepository),
            getCartItems = GetCartItems(cartRepository),
            updateCartItems = UpdateCartItems(cartRepository)
        )
    }

    @Provides
    @Singleton
    fun providePaymentUseCases(
        paymentRepository: PaymentRepository,
    ): PaymentUseCases {
        return PaymentUseCases(
            doPayment = DoPayment(paymentRepository)
        )
    }
}