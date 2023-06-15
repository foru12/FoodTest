package com.example.foodtest.View

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodtest.R
import com.example.foodtest.ViewModels.GPStracker
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(){
    private lateinit var txtLocation: TextView
    private lateinit var txtDate: TextView









    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setNav()
        setId()


        setLocation("Санкт-Петербург")
        setDate("12 Августа, 2023")
        createTracer()








    }

    private fun createTracer() {
        ActivityCompat.requestPermissions(
            this@MainActivity,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            123
        ) // запрос разрешение на использовние геопозиции


        val g = GPStracker(applicationContext) //создаём трекер

        val l = g.location // получаем координаты

        if (l != null) {
            val lat = l.latitude // широта
            val lon = l.longitude // долгота

            Log.e("широта","-->" + lat)
            Log.e("долгота","-->" + lon)
            Toast.makeText(applicationContext, "Широта: $lat\nДолгота: $lon", Toast.LENGTH_LONG)
                .show() // вывод в тосте
        }
    }


    private fun setId() {
        txtLocation = findViewById(R.id.txt_location)
        txtDate = findViewById(R.id.txt_date)

    }

    private fun setNav() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_menu_view)
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)
    }
    private fun setDate(date: String) {
        txtDate.text = date
    }
    private fun setLocation(location: String) {

        txtLocation.text = location
    }







}
