package com.example.foodtest.ViewModels.API

import android.util.Log
import com.example.foodtest.ViewModels.CallBack.CallBackInterfaceCategory
import com.example.foodtest.ViewModels.CallBack.CallBackRequestCategory
import com.example.foodtest.ViewModels.Service.ServiceCategory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ClientApiCategoty : CallBackInterfaceCategory {
    private var myCompositeDisposable: CompositeDisposable? = null
    override fun execute(
        url: String?,
        callback: CallBackRequestCategory?,
    ) {
        Log.e("Запуск Retrofit","...")
        myCompositeDisposable = CompositeDisposable()
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ServiceCategory::class.java)


        retrofit.getCategory()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())?.let {
                myCompositeDisposable?.add(
                it
                    .subscribe({
                        callback?.successReq(it);
                        Log.e("Subscribe","...")
                    }))
            }
    }

    override fun clear() {

        myCompositeDisposable?.clear()
    }
}