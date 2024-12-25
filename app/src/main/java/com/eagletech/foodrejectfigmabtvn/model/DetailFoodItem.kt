package com.eagletech.foodrejectfigmabtvn.model

import java.io.Serializable

data class DetailFoodItem(
    val imageUrl: Int,
    val title: String,
    val description: String,
    var isLike: Boolean
) : Serializable
