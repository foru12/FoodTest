package com.example.foodtest.View.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtest.Data.CONST.CONST.BASE_URL
import com.example.foodtest.Data.Сategories.DataCategories
import com.example.foodtest.Data.Сategories.Сategories
import com.example.foodtest.R
import com.example.foodtest.ViewModels.API.ClientApiCategoty
import com.example.foodtest.ViewModels.Adapters.AdapterCategories
import com.example.foodtest.ViewModels.CallBack.CallBackClickCaregory
import com.example.foodtest.ViewModels.CallBack.CallBackRequestCategory


class FragmentCategories : Fragment() , CallBackRequestCategory, CallBackClickCaregory {

    val restClientApiCategoty = ClientApiCategoty()
    private var сategoriesArrayList: ArrayList<Сategories>? = null
    private var myAdapter: AdapterCategories? = null
    private lateinit var recyclerView: RecyclerView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.e("Запуск главного фрагмента","...")

        restClientApiCategoty.execute(BASE_URL,this)







    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categories_list, container, false)

        recyclerView = view.findViewById(R.id.rc_list_categories)

        recyclerView.layoutManager = LinearLayoutManager(context)


        return view
    }



    override fun successReq(response: DataCategories?) {

        Log.e("Data","--->" + response?.сategories)

        сategoriesArrayList = response?.сategories?.let { ArrayList(it) }
        myAdapter = AdapterCategories(сategoriesArrayList!!, this,this)
        recyclerView.adapter = myAdapter






    }


    override fun errorReq(error: String?) {
        Toast.makeText(context,error, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        restClientApiCategoty.clear()
    }

    override fun onclick(position: Int) {

        Log.e("Вы в fragment и ваша позиция", "--->" + position)

    }


}