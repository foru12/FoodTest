package com.example.foodtest.ViewModels.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodtest.Data.Сategories.Сategories
import com.example.foodtest.R
import com.example.foodtest.View.Fragments.FragmentCategories


class AdapterCategories(

    private val dataCategories: ArrayList<Сategories>,
    val fragmentCategories: FragmentCategories


) : RecyclerView.Adapter<AdapterCategories.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txtName: TextView = itemView.findViewById(R.id.txt_name)
        val imageBack: ImageView = itemView.findViewById(R.id.categori_image_bg)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCategories.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_categories_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterCategories.ViewHolder, position: Int) {

        val data: Сategories = dataCategories.get(position)
        Log.e("Data","-->" + data.imageUrl)

        Glide
            .with(fragmentCategories)
            .load(data.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.menu_bg)
            .into(holder.imageBack);


        holder.txtName.text = data.name
        holder.itemView.setOnClickListener { v ->
            // получаем позицию в адаптере, которой соответсвует холдер
            val position = holder.adapterPosition
            // если холдер соответсвует какой-либо позиции в адаптере
            if (position != RecyclerView.NO_POSITION) {
                // уведомляем слушателя о нажатии
                itemClicked(position,data.id )

            }
        }

    }

    private fun itemClicked(position: Int, id: Int?) {
        //Тут можно сделать проверку на конкретный айтем и добавить остальные категории, но так как пока что категория одна,кнопка тоже
        /*var a = id?.minus(1)
        if (position == a){
            Log.e("Ваша позиция и айди","--> " + "position : $position" + " , id : $a")
        }*/
        //переход в меню
        Navigation.findNavController(fragmentCategories.requireView()).navigate(R.id.action_fragmentMain_to_fragmentMenu);


    }

    override fun getItemCount() = dataCategories.size

}