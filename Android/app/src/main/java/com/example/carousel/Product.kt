package com.example.carousel

import com.example.carousel.pojo.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class Product(
    val _id: String = "",
    val id: Int = 0,
    val vendorId: String = "Belethor",
    val title: String,
    val description: String = "",
    val amountLeft: Int = 0,
    val price: Double = 0.0,
    val maxPrice: Int = 0,
    val minPrice: Int = 0,
    val rating: Double = 3.0,
    val numberOfRatings: Int = 0,
    val comments: ArrayList<Comment> = ArrayList<Comment>(),
    val photoUrl: Int = 0,
    val tags: ArrayList<String> = ArrayList<String>() ,
    val brand: String = "",
    val shipmentPrice: Double = 0.0,
    val soldAmount: Int = 0,
    val releaseDate: Date = Date(),
    val cargoCompany: String = "",
    val category: String = "",
    val photos: ArrayList<String> = ArrayList<String>(),
    val vendorSpecifics: ArrayList<VendorSpecifics> = ArrayList<VendorSpecifics>()
    ) : Serializable


    fun responseToProduct(product: ProductData, main: MainProductData): Product{
        return Product(
            _id = main._id,
            title = main.title,
            description = main.description,
            price = product.default.price,
            amountLeft = product.default.amountLeft,
            shipmentPrice = product.default.shipmentPrice,
            cargoCompany = product.default.cargoCompany,
            rating = main.rating,
            photos = product.photos,
            tags = product.tags,
        )
    }

    fun responseToProductSearch(product: DataProductSearch, main: MainProduct): Product{
        return Product(
            _id = main._id,
            title = main.title,
            price = product.minPrice.toDouble(),
            minPrice = product.minPrice,
            maxPrice = product.maxPrice,
            rating = main.rating.toDouble(),
            numberOfRatings = main.numberOfRating,
            photos = product.product.photos,
            brand = product.brand,
            category = product.category,
        )
    }