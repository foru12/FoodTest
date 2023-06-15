package com.example.foodtest.ViewModels.Service

import com.example.foodtest.Data.CONST.CONST.CATEGORY_URL
import com.example.foodtest.Data.Сategories.DataCategories
import io.reactivex.Observable
import retrofit2.http.GET




interface ServiceCategory {
    @GET(CATEGORY_URL)
    fun getCategory(): Observable<DataCategories?>?
}