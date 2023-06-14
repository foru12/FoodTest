package com.example.foodtest.ViewModels.Service

import com.example.foodtest.Data.CONST.CONST.MENUURL
import com.example.foodtest.Data.Dishes.DataDishes
import com.example.foodtest.Data.Сategories.DataCategories
import io.reactivex.Observable
import retrofit2.http.GET

interface ServiceMenu {
    @GET(MENUURL)
    fun getMenu(): Observable<DataDishes?>?
}