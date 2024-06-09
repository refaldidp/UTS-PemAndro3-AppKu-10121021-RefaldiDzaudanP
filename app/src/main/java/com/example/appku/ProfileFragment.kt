package com.example.appku

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ProfileFragment : Fragment(), OnMapReadyCallback {

    lateinit var gfgImageButton1: ImageButton
    lateinit var gfgImageButton2: ImageButton
    lateinit var gfgImageButton3: ImageButton
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        mapView = view.findViewById(R.id.mapView3)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        gfgImageButton1 = view.findViewById(R.id.btn_insta)
        gfgImageButton2 = view.findViewById(R.id.btn_face)
        gfgImageButton3 = view.findViewById(R.id.btn_tiktok)

        view.findViewById<TextView>(R.id.t_phone).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:085624397667")
            startActivity(intent)
        }

        view.findViewById<TextView>(R.id.t_mail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:refaldi060503@outlook.com")
            startActivity(intent)
        }
        view.findViewById<TextView>(R.id.t_lokasi).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/S1JuPPJ7mLtWtxGR8"))
            startActivity(intent)
        }
        gfgImageButton1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/refaldi_dpratama?igsh=OXlzeHZtMDU0M3Vw"))
            startActivity(intent)
        }
        gfgImageButton2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/therefaldi.dzaudan?mibextid=ZbWKwL"))
            startActivity(intent)
        }
        gfgImageButton3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tiktok.com/@rereredp?_t=8n3u4jNC36Y&_r=1"))
            startActivity(intent)
        }
        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val myLocation = LatLng(-6.86882, 107.56201)
        googleMap.addMarker(MarkerOptions().position(myLocation).title("My Location"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15f))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
