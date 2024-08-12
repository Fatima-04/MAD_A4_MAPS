package com.fatima.maps_fatimatuzzahra_comp304_lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.fatima.maps_fatimatuzzahra_comp304_lab4.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    var selectedBuilding:String? = ""
    lateinit var finalLandmark: LatLng
    val sydney = LatLng(-34.0, 151.0)
    lateinit var casaLoma: LatLng
    lateinit var distillery_district: LatLng
    lateinit var royalOntarioMuseum : LatLng
    lateinit var artGalleryOfOntario: LatLng
    lateinit var rogersCentre : LatLng
    lateinit var bmoField : LatLng
    lateinit var cnTower : LatLng
    lateinit var ripleysAquarium : LatLng


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        selectedBuilding = intent.getStringExtra("landmark")
        findViewById<Button>(R.id.my_button).setOnClickListener {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        casaLoma = LatLng(43.67806037830529, -79.40950827301384)
        distillery_district = LatLng(43.6503789980686, -79.35904398502156)
        royalOntarioMuseum = LatLng(43.66781056105826, -79.39478783262437)
        artGalleryOfOntario = LatLng(43.65373853508124, -79.39251230378946)
        rogersCentre = LatLng(43.64166117669916, -79.3894067461189)
        bmoField = LatLng(43.633278884319, -79.41863766146186)
        cnTower = LatLng(43.6431668197335, -79.38736076146138)
        ripleysAquarium = LatLng(43.642360926529314, -79.38660220379013)

        if(selectedBuilding == "Casa Loma"){
            finalLandmark = casaLoma
        }else if(selectedBuilding == "Distillery District"){
            finalLandmark = distillery_district
        }else if(selectedBuilding == "Royal Ontario Museum"){
            finalLandmark = royalOntarioMuseum
        }else if(selectedBuilding == "Art Gallery Of Ontario"){
            finalLandmark = artGalleryOfOntario
        }else if(selectedBuilding == "Rogers Centre"){
            finalLandmark = rogersCentre
        }else if(selectedBuilding == "BMO Field"){
            finalLandmark = bmoField
        }else if(selectedBuilding == "CN Tower"){
            finalLandmark = cnTower
        }else if (selectedBuilding == "Ripley's Aquarium"){
            finalLandmark = ripleysAquarium
        }else{
            finalLandmark = sydney
        }

        mMap.addMarker(MarkerOptions().position(finalLandmark).title("Marker in $selectedBuilding"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(finalLandmark,15f))

    }
}