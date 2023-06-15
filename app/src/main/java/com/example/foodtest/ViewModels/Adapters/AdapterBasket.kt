package com.example.foodtest.ViewModels.Adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.foodtest.Basket.DataBasket
import com.example.foodtest.Data.Dishes.Dishes
import com.example.foodtest.R
import com.example.foodtest.View.Fragments.FragmentBasket


class AdapterBasket(
    private val dataBasket: ArrayList<DataBasket>,
    val fragmentBasket: FragmentBasket,


    ) : RecyclerView.Adapter<AdapterBasket.ViewHolder>() {
    var SCORE = 1;
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val image: ImageView = itemView.findViewById(R.id.image_bg_basket)
        val minus: ImageView = itemView.findViewById(R.id.img_minus)
        val plus: ImageView = itemView.findViewById(R.id.img_plus)
        val name: TextView = itemView.findViewById(R.id.txt_name_basket)
        val price: TextView = itemView.findViewById(R.id.txt_price_basket)
        val weight: TextView = itemView.findViewById(R.id.txt_weight_basket)
        val count: TextView = itemView.findViewById(R.id.txt_count)



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBasket.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_basket_item, parent, false)
        return AdapterBasket.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterBasket.ViewHolder, position: Int) {
        val data: DataBasket = dataBasket.get(position)
        holder.minus.setOnClickListener{

            if (SCORE == 0){
                removeItem(position)
            }else{
                SCORE--
                holder.count.text = SCORE.toString()
            }


        }
        holder.plus.setOnClickListener{
            SCORE++
            holder.count.text = SCORE.toString()
        }

        holder.name.text = data.name
        holder.price.text = data.price
        holder.weight.text = data.weight
        Glide
            .with(fragmentBasket)
            .load(data.imageUrl)
            .fitCenter()
            .placeholder(R.drawable.menu_bg)
            .into(holder.image);







    }

    private fun removeItem(position: Int) {

        // удаляем элемент из списка
        dataBasket.removeAt(position) // удаляем элемент из списка с позиции pos
        notifyItemRangeChanged(0,dataBasket.size) // указываем адаптеру новый диапазон элементов
        notifyItemRemoved(position) // указываем адаптеру, что один элемент удалился
    }

    override fun getItemCount(): Int {
        return dataBasket.size

    }






}