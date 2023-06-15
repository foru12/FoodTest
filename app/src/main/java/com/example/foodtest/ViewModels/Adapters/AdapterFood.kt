package com.example.foodtest.ViewModels.Adapters

import android.util.Log
import android.view.Display
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.foodtest.Data.Dishes.Dishes
import com.example.foodtest.Data.Сategories.Сategories
import com.example.foodtest.R
import com.example.foodtest.View.Fragments.FragmentCategories
import com.example.foodtest.View.Fragments.FragmentMenu
import com.example.foodtest.ViewModels.CallBack.CallBackClickCaregory
import com.example.foodtest.ViewModels.CallBack.CallBackClickMenu


class AdapterFood(
    private val dataDishes: ArrayList<Dishes>,
    val fragmentMenu: FragmentMenu,
    val onItemClickListener: CallBackClickMenu
) : RecyclerView.Adapter<AdapterFood.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txtName: TextView = itemView.findViewById(R.id.txt_name_menu)
        val imageBack: ImageView = itemView.findViewById(R.id.categori_image_bg_menu)




    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFood.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_menu_item, parent, false)
        return AdapterFood.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterFood.ViewHolder, position: Int) {
        val data: Dishes = dataDishes.get(position)
        Log.e("Data","-->" + data.imageUrl)

        Glide
            .with(fragmentMenu)
            .load(data.imageUrl)
            .fitCenter()
            .placeholder(R.drawable.menu_bg)
            .into(holder.imageBack);


        holder.txtName.text = data.name
        holder.itemView.setOnClickListener { v ->
            // получаем позицию в адаптере, которой соответсвует холдер
            val position = holder.adapterPosition
            // если холдер соответсвует какой-либо позиции в адаптере
            if (position != RecyclerView.NO_POSITION) {
                var a = data.id?.minus(1)

                data.id?.let {
                    onItemClickListener?.onclick(data.name,data.price.toString(),data.weight.toString(),data.description,data.imageUrl.toString(),
                        it
                    )
                }

            }
        }
    }

    override fun getItemCount() = dataDishes.size



}