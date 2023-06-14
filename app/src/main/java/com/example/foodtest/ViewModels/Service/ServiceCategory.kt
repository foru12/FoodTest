package com.example.foodtest.ViewModels.Service

import com.example.foodtest.Data.CONST.CONST.CATEGORYURL
import com.example.foodtest.Data.Сategories.DataCategories
import io.reactivex.Observable
import retrofit2.http.GET




interface ServiceCategory {
    @GET(CATEGORYURL)
    fun getCategory(): Observable<DataCategories?>?
}