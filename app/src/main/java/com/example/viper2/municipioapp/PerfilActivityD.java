package com.example.viper2.municipioapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivityD extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username="",correo="";
    Intent intent;
    ImageView fperfil;
    TextView eUsername,eCorreo;
    TextView textViewDrawer1,textViewDrawer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_d);

        textViewDrawer1 = (TextView) findViewById(R.id.P_textViewDrawer1);
        textViewDrawer2 = (TextView) findViewById(R.id.P_textViewDrawer2);
        eUsername = (TextView) findViewById(R.id.eUsernameD);
        eCorreo = (TextView) findViewById(R.id.eCorreoD);
        fperfil = (ImageView) findViewById(R.id.fperfilD);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle box =getIntent().getExtras();
        username = String.valueOf(box.getString("username"));
        correo= String.valueOf(box.getString("correo"));

        //Toast.makeText(getApplicationContext(),username,Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(),correo,Toast.LENGTH_SHORT).show();

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //textViewDrawer1.setText(username);
        //((TextView) findViewById(R.id.P_textViewDrawer2)).setText(correo);
        eUsername.setText(username);
        eCorreo.setText(correo);

        Resources res = getResources();
        int resourceId = res.getIdentifier(username, "drawable", getPackageName());

        if(resourceId == 0)
        {
            fperfil.setImageResource(R.drawable.user);

        }else {
            fperfil.setImageResource(resourceId);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_pmain:
                intent = new Intent (PerfilActivityD.this, MainActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_list:
                intent = new Intent (PerfilActivityD.this, ListActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_hotel:
                intent = new Intent (PerfilActivityD.this, HotelesActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_rest:
                intent = new Intent (PerfilActivityD.this, RestActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_qh:
                intent = new Intent (PerfilActivityD.this, QhActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_mi_perfil:
                intent = new Intent (PerfilActivityD.this, PerfilActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_sing_out:
                intent = new Intent (PerfilActivityD.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Sección cerrada", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
