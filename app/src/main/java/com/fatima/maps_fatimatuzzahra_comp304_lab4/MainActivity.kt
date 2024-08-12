package com.fatima.maps_fatimatuzzahra_comp304_lab4

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val types = arrayOf("Historical Buildings", "Museums", "Stadiums", "Attractions")
        val customAdapter = CustomAdapter(types)


        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

        recyclerView.setOnClickListener {
            val clickedBuilding = it.findViewById<TextView>(R.id.textView).text.toString()
            val intent = Intent(this, LandMark::class.java )
            intent.putExtra("landmark", clickedBuilding)
            startActivity(intent)

        }
    }
}