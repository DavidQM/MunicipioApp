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

    String Lat1="0",Lon1="0",Lat2="0",Lon2="0",Lat3="0",Lon3="0";
    String str1="",str2="",str3="";
    int mapa=0;
   float z=0;
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Bundle box =getIntent().getExtras();
        mapa = box.getInt("mapa");
        //Lat= String.valueOf(box.getString("Lat"));

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


        switch (mapa){
            case 0:
                Toast.makeText(getApplicationContext(),"0",Toast.LENGTH_SHORT).show();
                Lat1="6.2441988";
                Lon1="-75.6512524";
                Lat2="6.2328697";
                Lon2="-75.161758";
                Lat3="6.170561";
                Lon3="-75.4293823";
                str1= "Medellin";
                str2= "Parroquia Nuestra Señora Del Carmen De Guatapé";
                str3= "Aeropuerto JMC";
                z=8;
                break;
            case 1:Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                Lat1="6.2263963";
                Lon1="-75.1808065";
                str1= getResources().getString(R.string.HotelUno);
                Lat2="6.2477091";
                Lon2="-75.1482154";
                str2= getResources().getString(R.string.HotelDos);
                Lat3="6.2347772";
                Lon3="-75.16233";
                str3= getResources().getString(R.string.HotelTres);
                z=13;
                break;
            case 2:Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                Lat1="6.2352118";
                Lon1="-75.1621945";
                str1= getResources().getString(R.string.RestUno);
                Lat2="6.2334243";
                Lon2="-75.1593163";
                str2= getResources().getString(R.string.RestDos);
                Lat3="6.2341203";
                Lon3="-75.1607269";
                str3= getResources().getString(R.string.RestTres);
                z=16;
                break;
            case 3:Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                Lat1="6.2289578";
                Lon1="-75.1812887";
                str1= getResources().getString(R.string.QhUno);
                Lat2="6.2350005";
                Lon2="-75.162179";
                str2= getResources().getString(R.string.QhDos);
                Lat3="6.2337781";
                Lon3="-75.1632163";
                str3= getResources().getString(R.string.QhTres);
                z=13;
                break;
            default:Toast.makeText(getApplicationContext(),"default",Toast.LENGTH_SHORT).show();
                break;

        }

        // Add a marker in Sydney and move the camera
        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng udea = new LatLng(6.2669533,-75.5713);//cargamos a la variable udea la ubucacion de la Universidad de Antioquia
        mMap.addMarker(new MarkerOptions().anchor(0.0f,1.0f).position(udea).title("Universidad de Antioquia").snippet("Nuestra alama Mater").icon(BitmapDescriptorFactory.fromResource(R.drawable.swimming_pool)));//agregamos y nombramos el marcador de UdeA
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udea,15));//movemos la camara a la udea , zoom =15
        */
        LatLng Luno =new LatLng(Double.parseDouble(Lat1),Double.parseDouble(Lon1));
        mMap.addMarker(new MarkerOptions().position(Luno).title(str1).snippet(str1));

        LatLng Ldos =new LatLng(Double.parseDouble(Lat2),Double.parseDouble(Lon2));
        mMap.addMarker(new MarkerOptions().position(Ldos).title(str2).snippet(str2));

        LatLng Ltres =new LatLng(Double.parseDouble(Lat3),Double.parseDouble(Lon3));
        mMap.addMarker(new MarkerOptions().position(Ltres).title(str3).snippet(str3));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ltres,z));
                /*
        LatLng ensayo =new LatLng(Double.parseDouble(Lat),Double.parseDouble(Lon));
        mMap.addMarker(new MarkerOptions().position(ensayo).title("Marker in ensayo").icon(BitmapDescriptorFactory.fromResource(R.drawable.swim)));
        Toast.makeText(getApplicationContext(),String.valueOf(Lat),Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),String.valueOf(Lon),Toast.LENGTH_SHORT).show();
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ensayo));
        */
        /*
        //
        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(sydney)
                .add(udea)
        );
        */

    }

}
