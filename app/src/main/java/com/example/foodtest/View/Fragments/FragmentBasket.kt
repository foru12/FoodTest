package com.example.foodtest.View.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtest.Basket.DataBasket
import com.example.foodtest.Data.Сategories.Сategories
import com.example.foodtest.R
import com.example.foodtest.ViewModels.Adapters.AdapterBasket
import com.example.foodtest.ViewModels.Adapters.AdapterCategories
import com.example.foodtest.ViewModels.CallBack.CallBackBasket


class FragmentBasket : Fragment(), CallBackBasket {

    private var basketList: ArrayList<DataBasket>? = null
    private var myAdapter: AdapterBasket? = null
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_basket_list, container, false)
        recyclerView = view.findViewById(R.id.rc_list_basket)

        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onAdditem(imageUrl: String, name: String, price: String, weight: String) {
        basketList?.add(DataBasket(imageUrl,name,price,weight))
        myAdapter = AdapterBasket(basketList!!, this)
        recyclerView.adapter = myAdapter
    }


}