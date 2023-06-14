package com.example.foodtest.Data.Сategories

import com.google.gson.annotations.SerializedName

data class Сategories (

    @SerializedName("id"        ) var id       : Int?    = null,
    @SerializedName("name"      ) var name     : String? = null,
    @SerializedName("image_url" ) var imageUrl : String? = null

)
