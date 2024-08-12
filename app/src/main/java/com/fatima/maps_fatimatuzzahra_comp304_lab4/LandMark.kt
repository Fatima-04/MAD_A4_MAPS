package com.fatima.maps_fatimatuzzahra_comp304_lab4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LandMark : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_land_mark)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val selectedBuilding = intent.getStringExtra("landmark")
        val historical_li = arrayOf("Casa Loma", "Distillery District")
        val museums_li = arrayOf("Royal Ontario Museum", "Art Gallery of Ontario")
        val stadiums_li = arrayOf("Rogers Centre", "BMO Field")
        val attractions_li = arrayOf("CN Tower", "Ripley's Aquarium")

        lateinit var finalList:Array<String>
        if(selectedBuilding == "Historical Buildings"){
            finalList = historical_li
        } else if (selectedBuilding == "Museums"){
            finalList = museums_li
        } else if(selectedBuilding == "Attractions"){
            finalList = attractions_li
        } else if(selectedBuilding == "Stadiums"){
            finalList = stadiums_li
        }else{
            finalList = arrayOf(" ")
        }


        val customAdapter = LandmarkCustomAdapter(finalList)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

    }
}