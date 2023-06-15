package com.example.foodtest.ViewModels.Service

import com.example.foodtest.Data.CONST.CONST.MENU_URL
import com.example.foodtest.Data.Dishes.DataDishes
import io.reactivex.Observable
import retrofit2.http.GET

interface ServiceMenu {
    @GET(MENU_URL)
    fun getMenu(): Observable<DataDishes?>?
}