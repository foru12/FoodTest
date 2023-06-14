package com.example.foodtest.ViewModels.CallBack
import com.example.foodtest.Data.Сategories.DataCategories


interface CallBackRequestCategory {
    fun successReq(response: DataCategories?)
    fun errorReq(error: String?)
}