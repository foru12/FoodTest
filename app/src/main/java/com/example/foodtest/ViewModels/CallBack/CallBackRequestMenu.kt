package com.example.foodtest.ViewModels.CallBack

import com.example.foodtest.Data.Dishes.DataDishes
import com.example.foodtest.Data.Сategories.DataCategories

interface CallBackRequestMenu {
    fun successReq(response: DataDishes?)
    fun errorReq(error: String?)
}