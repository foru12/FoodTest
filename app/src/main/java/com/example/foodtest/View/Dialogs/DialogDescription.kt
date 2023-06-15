package com.example.foodtest.View.Dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CancellationSignal.OnCancelListener
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.foodtest.Basket.DataBasket
import com.example.foodtest.R
import com.example.foodtest.ViewModels.CallBack.CallBackBasket
import com.example.foodtest.ViewModels.CallBack.CallBackClickCaregory


open class DialogDescription( val callBackBasket: CallBackBasket)  : DialogFragment() {


    private lateinit var  menuImage: ImageView
    private lateinit var  txtname: TextView
    private lateinit var  txtPrice: TextView
    private lateinit var  txtWeight: TextView
    private lateinit var  txtDescription: TextView
    private lateinit var  btnAddBasket: Button

    open fun newInstance(name: String?,price:String?,weight: String?,desk:String?,urlIm:String,id:Int,callBackBasket: CallBackBasket): DialogDescription? {
        val frag = DialogDescription(callBackBasket)
        val args = Bundle()

        args.putString("name", name)
        args.putString("price", price)
        args.putString("weight", weight)
        args.putString("desk", desk)
        args.putString("urlIm", urlIm)
        args.putInt("id", id)
        frag.setArguments(args)
        return frag
    }





    //creating the Dialog Fragment.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_description_layout, container, false)
    }



    //tasks that need to be done after the creation of Dialog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        menuImage = view.findViewById(R.id.image_bg_menu)
        txtname = view.findViewById(R.id.txt_name_menu_dialog)
        txtPrice = view.findViewById(R.id.txt_price_menu_dialog)
        txtDescription = view.findViewById(R.id.txt_description_menu_dialog)
        btnAddBasket = view.findViewById(R.id.btn_addBusket_menu_dialog)
        txtWeight = view.findViewById(R.id.txt_weight_menu_dialog)





        btnAddBasket.setOnClickListener {
            Log.e("Basket","Add")

            getArguments()?.getString("urlIm")?.let { it1 ->
                getArguments()?.getString("name")?.let { it2 ->
                    getArguments()?.getString("price")?.let { it3 ->
                        getArguments()?.getString("weight")?.let { it4 ->
                            callBackBasket.onAdditem(
                                it1,
                                it2,
                                it3,
                                it4
                            )
                        }
                    }
                }
            }



            dialog?.dismiss()
        }

        txtname.text =  getArguments()?.getString("name")
        txtPrice.text =  getArguments()?.getString("price")
        txtWeight.text =  getArguments()?.getString("weight")
        txtDescription.text =  getArguments()?.getString("desk")

        Glide
            .with(this)
            .load(getArguments()?.getString("urlIm"))
            .fitCenter()
            .placeholder(R.drawable.menu_bg)
            .into(menuImage);



    }



    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,

        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }








}