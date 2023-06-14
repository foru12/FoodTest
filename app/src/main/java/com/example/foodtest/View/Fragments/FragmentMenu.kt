package com.example.foodtest.View.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtest.Data.CONST.CONST.BASEURL
import com.example.foodtest.Data.Dishes.DataDishes
import com.example.foodtest.Data.Dishes.Dishes
import com.example.foodtest.R
import com.example.foodtest.ViewModels.API.ClientApiMenu
import com.example.foodtest.ViewModels.Adapters.AdapterCategories
import com.example.foodtest.ViewModels.Adapters.AdapterFood
import com.example.foodtest.ViewModels.CallBack.CallBackRequestCategory
import com.example.foodtest.ViewModels.CallBack.CallBackRequestMenu


class FragmentMenu : Fragment(), CallBackRequestMenu {
    val restClientApiMenu = ClientApiMenu()
    private var menuArrayList: ArrayList<Dishes>? = null
    private var myAdapter: AdapterFood? = null
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        restClientApiMenu.execute(BASEURL,this)

       /* btnCustomDialog.setOnClickListener {
            CustomDialogFragment.newInstance(
                getString(R.string.custom_dialog_title),
                getString(R.string.custom_dialog_subTitle)
            ).show(supportFragmentManager, CustomDialogFragment.TAG)


        }
*/

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
        myAdapter = AdapterFood(menuArrayList!!, this)
        recyclerView.adapter = myAdapter


    }

    override fun errorReq(error: String?) {
       Toast.makeText(context,error,Toast.LENGTH_SHORT).show()
    }


}