package com.example.foodtest.View.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtest.Data.CONST.CONST.BASE_URL
import com.example.foodtest.Data.Dishes.DataDishes
import com.example.foodtest.Data.Dishes.Dishes
import com.example.foodtest.R
import com.example.foodtest.View.Dialogs.DialogDescription
import com.example.foodtest.ViewModels.API.ClientApiMenu
import com.example.foodtest.ViewModels.Adapters.AdapterFood
import com.example.foodtest.ViewModels.CallBack.CallBackClickCaregory
import com.example.foodtest.ViewModels.CallBack.CallBackClickMenu
import com.example.foodtest.ViewModels.CallBack.CallBackRequestMenu


class FragmentMenu : Fragment(), CallBackRequestMenu , CallBackClickMenu {
    val restClientApiMenu = ClientApiMenu()
    private var menuArrayList: ArrayList<Dishes>? = null
    private var myAdapter: AdapterFood? = null
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restClientApiMenu.execute(BASE_URL,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu_list, container, false)
        recyclerView = view.findViewById(R.id.rc_list_menu)
        recyclerView.layoutManager = GridLayoutManager(context,3)

        return view
    }

    override fun successReq(response: DataDishes?) {
        Log.e("Data","--->" + response?.dishes)

        menuArrayList = response?.dishes?.let { ArrayList(it) }
        myAdapter = AdapterFood(menuArrayList!!, this,this)
        recyclerView.adapter = myAdapter


    }

    override fun errorReq(error: String?) {
       Toast.makeText(context,error,Toast.LENGTH_SHORT).show()
    }

    override fun onclick(name: String?,price:String?,weight: String?,desk:String?,urlIm:String,id:Int) {


        Log.e("Вы в fragment Menu и ваша позиция", "--->" + "\n" + name + "\n" + price+ "\n" + weight+ "\n" + desk+ "\n" + urlIm+ "\n" + id)
        openDialod(name,price,weight,desk,urlIm,id)

    }

    private fun openDialod(name: String?,price:String?,weight: String?,desk:String?,urlIm:String,id:Int) {

        val dialogFragment: DialogDescription? =
            DialogDescription(FragmentBasket()).newInstance(name,price,weight,desk,urlIm,id,FragmentBasket())
        val fm: FragmentManager? = activity?.getSupportFragmentManager()
        fm?.let { dialogFragment?.show(it,"") }


    }


}