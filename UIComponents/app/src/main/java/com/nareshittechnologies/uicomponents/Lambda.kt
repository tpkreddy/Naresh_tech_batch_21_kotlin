package com.nareshittechnologies.uicomponents

data class Product(val name:String, val price:Double, var discountedPrice:Double = price)

fun main(){
    val items = listOf(
        Product("Laptop", 1200.0),
        Product("Phone", 800.0),
        Product("Headphones", 50.0),
        Product("Tablet",900.0),
        Product("Power Bank", 400.0),
        Product("Refrigerator", 300.0),
        Product("Camera",350.0)
    )

    // you want to give 5% discount on all the products that are priced below or equal 500 rupees
    // you want to give 10% discount on all the products that are priced above 500 rupees

    filterProducts(items){product ->
        if(product.price <=500.0){
           product.discountedPrice =  product.price*0.95
        }else{
           product.discountedPrice =  product.price*0.90
        }
    }

    println("$items")

}

fun filterProducts(products:List<Product>, priceDiscount:(Product)->Unit){
    return products.forEach(priceDiscount)
}