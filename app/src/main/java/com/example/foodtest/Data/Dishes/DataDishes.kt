package com.example.foodtest.Data.Dishes

import com.google.gson.annotations.SerializedName


data class DataDishes (

    @SerializedName("dishes" ) var dishes : ArrayList<Dishes> = arrayListOf()

)