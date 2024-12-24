package com.eagletech.foodrejectfigmabtvn.model


import java.io.Serializable

data class FoodItem(
    val imageUrl: Int,
    val title: String,
    val recipeCount: Int
) : Serializable
