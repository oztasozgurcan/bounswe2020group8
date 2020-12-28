package com.example.carousel.pojo

import com.example.carousel.*
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class ResponseLogin(
    @Expose @SerializedName("tokenCode") val tokenCode: String,
    @Expose @SerializedName("returnMessage") val returnMessage: String,
    @Expose @SerializedName("returnCode") val returnCode: Int
)

data class ResponseHeader(
    @Expose @SerializedName("returnMessage") val returnMessage: String,
    @Expose @SerializedName("returnCode") val returnCode: Int
)

data class ResponseCustomerMe(
    @Expose @SerializedName("returnMessage") val returnMessage: String,
    @Expose @SerializedName("returnCode") val returnCode: Int,
    @Expose @SerializedName("data") val data: DataCustomerMe
)

data class ResponseVendorMe(
    @Expose @SerializedName("returnMessage") val returnMessage: String,
    @Expose @SerializedName("returnCode") val returnCode: Int,
    @Expose @SerializedName("data") val data: DataVendorMe
)


data class ResponseError(
    @Expose @SerializedName("returnMessage") val returnMessage: String,
    @Expose @SerializedName("returnCode") val returnCode: Int
)

data class DataCustomerMe(
    @Expose @SerializedName("_id") var id: String,
    @Expose @SerializedName("name")var name: String,
    @Expose @SerializedName("lastName")var lastName: String,
    @Expose @SerializedName("email")var email: String,
    @Expose @SerializedName("isSuspended")var isSuspended: Boolean,
    @Expose @SerializedName("isActive")var isActive: Boolean,
    //@Expose @SerializedName("shoppingLists")var shoppingLists: List<List<Product>>?,
    @Expose @SerializedName("orders")var orders: List<ExampleObject>?,
    @Expose @SerializedName("shoppingCart")var cart: List<ExampleObject>?,
    @Expose @SerializedName("addresses")var addresses: ArrayList<AddressJSON>?,
    @Expose @SerializedName("phoneNumber")var telephoneNumber: String?,
    @Expose @SerializedName("birthday")var birthday: String?,
    @Expose @SerializedName("creditCards")var creditCards:  ArrayList<CreditCardJSON>?
)


data class DataVendorMe(
    @Expose @SerializedName("id") val id: String,
    @Expose @SerializedName("name")val name: String,
    @Expose @SerializedName("lastName")val lastName: String,
    @Expose @SerializedName("email")val email: String,
    @Expose @SerializedName("isSuspended")val isSuspended: Boolean,
    @Expose @SerializedName("isActive")val isActive: Boolean,
    @Expose @SerializedName("companyName")val shoppingLists: List<ExampleObject>,
    @Expose @SerializedName("companyDomainName")val cart: List<ExampleObject>,
    @Expose @SerializedName("aboutCompany")val addresses: List<ExampleObject>,
    @Expose @SerializedName("IBAN")val telephoneNumber: String,
    @Expose @SerializedName("address")val birthday: String,
    @Expose @SerializedName("location")val creditCards: List<ExampleObject>
)

data class ExampleObject(
    @Expose @SerializedName("id") val id: String,
)

data class ResponseChangePassword(
    @Expose @SerializedName("returnCode") val returnCode: Int,
    @Expose @SerializedName("returnMessage") val returnMessage: String
)


data class ResponseMainProduct(
    @Expose @SerializedName("data") val data: MainProductData,
    @Expose @SerializedName("returnCode") val returnCode: Int,
    @Expose @SerializedName("returnMessage") val returnMessage: String
) : Serializable
data class ResponseProduct(
    @Expose @SerializedName("data") val data: ProductData,
    @Expose @SerializedName("returnCode") val returnCode: Int,
    @Expose @SerializedName("returnMessage") val returnMessage: String
) : Serializable

data class ResponseAllProducts(
    @Expose @SerializedName("results") val results: Int,
    @Expose @SerializedName("data") val data: ArrayList<AllProductData>,
    @Expose @SerializedName("returnCode") val returnCode: Int,
    @Expose @SerializedName("returnMessage") val returnMessage: String
) : Serializable

data class ProductData(
    @Expose @SerializedName("default") val default: VendorDefaults,
    @Expose @SerializedName("tags") val tags: ArrayList<String>,
    @Expose @SerializedName("photos") val photos: ArrayList<String>,
    @Expose @SerializedName("_id") val _id: String,
    @Expose @SerializedName("parameters") val parameters: ArrayList<Parameter>,
    @Expose @SerializedName("vendorSpecifics") val vendorSpecifics: ArrayList<VendorDefaults>,
    @Expose @SerializedName("parentProduct") val parentProduct: String,
    @Expose @SerializedName("brand") val brand: String,
    @Expose @SerializedName("category") val category: String,
    @Expose @SerializedName("createdAt") val createdAt: Date,
    @Expose @SerializedName("updatedAt") val updatedAt: Date,
) : Serializable
data class AllProductData(
    @Expose @SerializedName("default") val default: VendorDefaults,
    @Expose @SerializedName("tags") val tags: ArrayList<String>,
    @Expose @SerializedName("photos") val photos: ArrayList<String>,
    @Expose @SerializedName("_id") val _id: String,
    @Expose @SerializedName("parameters") val parameters: ArrayList<Parameter>,
    @Expose @SerializedName("vendorSpecifics") val vendorSpecifics: ArrayList<VendorSpecifics>,
    @Expose @SerializedName("parentProduct") val parentProduct: String,
    @Expose @SerializedName("brand") val brand: String,
    @Expose @SerializedName("category") val category: String,
    @Expose @SerializedName("createdAt") val createdAt: Date,
    @Expose @SerializedName("updatedAt") val updatedAt: Date,
) : Serializable
data class MainProductData(
    @Expose @SerializedName("tags") val tags: List<String>,
    @Expose @SerializedName("_id") val _id: String,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("parameters") val parameters: List<Parameters>,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("rating") val rating: Double,
    @Expose @SerializedName("brand") val brand: String,
    @Expose @SerializedName("soldAmount") val soldAmount: Int,
    @Expose @SerializedName("category") val category: String,
    @Expose @SerializedName("isConfirmed") val isConfirmed : Boolean,
    @Expose @SerializedName("createdAt") val createdAt: Date,
    @Expose @SerializedName("updatedAt") val updatedAt: Date,
    @Expose @SerializedName("photos") val photos: ArrayList<String>
) : Serializable

data class Parameters(
    @Expose @SerializedName("values") val value: ArrayList<String>,
    @Expose @SerializedName("name") val name: String
) : Serializable
data class Parameter(
    @Expose @SerializedName("value") val value: String,
    @Expose @SerializedName("name") val name: String
) : Serializable


data class VendorDefaults(
    @Expose @SerializedName("vendorID") val vendorID: String,
    @Expose @SerializedName("price") val price:  Double,
    @Expose @SerializedName("amountLeft") val amountLeft: Int,
    @Expose @SerializedName("shipmentPrice") val shipmentPrice: Double,
    @Expose @SerializedName("cargoCompany")val cargoCompany: String
) : Serializable

data class VendorSpecifics(
    @Expose @SerializedName("vendorID") val vendorID: VendorID?,
    @Expose @SerializedName("price") val price:  Double,
    @Expose @SerializedName("amountLeft") val amountLeft: Int,
    @Expose @SerializedName("shipmentPrice") val shipmentPrice: Double,
    @Expose @SerializedName("cargoCompany")val cargoCompany: String
) : Serializable

data class VendorID(
    @Expose @SerializedName("_id") val _id: String,
    @Expose @SerializedName ("companyName") val companyName: String
) : Serializable


data class ResponseGetCategories(
    @Expose @SerializedName("returnMessage") val returnMessage: String,
    @Expose @SerializedName("returnCode") val returnCode: Int,
    @Expose @SerializedName("results") val results: Int,
    @Expose @SerializedName("data") val data: List<Category>
)

data class Category(
    @Expose @SerializedName("_id") val _id: String,
    @Expose @SerializedName("name") val name: String
)

data class ResponseGetComments(
    @Expose @SerializedName("data") val data: ArrayList<Comment>
)

data class PostComment(
    @Expose @SerializedName("text") val text: String
)

data class ResponseCart(
    @Expose @SerializedName("productId") val productId: String,
    @Expose @SerializedName("vendorId") val vendorId: String,
    @Expose @SerializedName("amount") val amount: Int
)

data class DeleteCart(
    @Expose @SerializedName("productId") val productId: String,
    @Expose @SerializedName("vendorId") val vendorId: String,
)

