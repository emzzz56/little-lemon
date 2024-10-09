package com.emz.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MenuNetwork(
    @SerialName(value = "menu")
    val menuItems: List<MenuItemNetwork>
)

@Serializable
class MenuItemNetwork (
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "title")
    val title: String,
    @SerialName(value="description")
    val description: String,
    @SerialName(value="price")
    val price: Double,
    @SerialName(value="image")
    val image: String,
    @SerialName(value = "category")
    val category: String
)