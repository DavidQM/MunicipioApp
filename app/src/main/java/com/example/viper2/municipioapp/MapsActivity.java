package com.example.viper2.municipioapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;




public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    String Lat="6.204687",Lon="-75.5859901";
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        /*
        Bundle box =getIntent().getExtras();
        Lon = String.valueOf(box.getString("Lon"));
        Lat= String.valueOf(box.getString("Lat"));
        */
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mi localizacion
        mMap.setMyLocationEnabled(true);

        //tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker in Sydney and move the camera
        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        LatLng udea = new LatLng(6.2669533,-75.5713);//cargamos a la variable udea la ubucacion de la Universidad de Antioquia
        mMap.addMarker(new MarkerOptions().anchor(0.0f,1.0f).position(udea).title("Universidad de Antioquia").snippet("Nuestra alama Mater").icon(BitmapDescriptorFactory.fromResource(R.drawable.swimming_pool)));//agregamos y nombramos el marcador de UdeA
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udea,15));//movemos la camara a la udea , zoom =15

        LatLng ensayo =new LatLng(Double.parseDouble(Lat),Double.parseDouble(Lon));
        mMap.addMarker(new MarkerOptions().position(ensayo).title("Marker in ensayo").icon(BitmapDescriptorFactory.fromResource(R.drawable.swim)));
        Toast.makeText(getApplicationContext(),String.valueOf(Lat),Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),String.valueOf(Lon),Toast.LENGTH_SHORT).show();
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ensayo));

        /*
        //
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(sydney)
                .add(udea)
        );
        */

    }

}
