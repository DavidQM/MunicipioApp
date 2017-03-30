package com.example.viper2.municipioapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    String username="",correo="";
    Intent intent;
   // SharedPreferences prefs;//practica 5
   // SharedPreferences.Editor editor;//practica 5

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);//practica 5
    //    editor = prefs.edit();//practica 5

        Bundle box =getIntent().getExtras();

        username = String.valueOf(box.getString("username"));
        correo= String.valueOf(box.getString("correo"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_perfil:
                intent = new Intent (MainActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.hotel:
                intent = new Intent (MainActivity.this, HotelesActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.rest:
                intent = new Intent (MainActivity.this, RestsActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.qh:
                intent = new Intent (MainActivity.this, QhActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.sign_out:
                intent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Sección cerrada", Toast.LENGTH_SHORT).show();
                finish();
                //editor.putInt("login",-1);//sobre escribimos con -1 (cerramos sesion)//practica 5
                //editor.commit();//practica 5
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
