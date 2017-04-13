package com.example.viper2.municipioapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivityD extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    String username="",correo="";
    //String username="david",correo="a@a";
    Intent intent;
    TextView textViewDrawer1,textViewDrawer2;

    private Lista_Entrada[] datos = new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.guatape_min,"Municipio Guatape","Informacion General del Municipio.","Guatape(Ant)"),
            new Lista_Entrada(R.drawable.hbenjamar_min,"Hoteles","Lugares de Hospedaje.","Guatape(Ant)"),
            new Lista_Entrada(R.drawable.rlafogata_min,"Restaurantes","Diversidad gastronomica con buena mesa.","Guatape(Ant)"),
            new Lista_Entrada(R.drawable.zocalos_min,"¿Que Hacer?","Planes divertidos y emocionantes.","Guatape(Ant)")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_d);

        textViewDrawer1 = (TextView) findViewById(R.id.textViewDrawer1);
        textViewDrawer2 = (TextView) findViewById(R.id.textViewDrawer2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

        //((TextView) findViewById(R.id.textViewDrawer1)).setText(username);
        //((TextView) findViewById(R.id.textViewDrawer2)).setText(correo);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView =(ListView) findViewById(R.id.list);
        Adapter adapter = new Adapter(this,datos);
        listView.setAdapter(adapter);

        //Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                //String opcion = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                //Toast.makeText(getApplicationContext(),opcion,Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        intent = new Intent(ListActivityD.this, MainActivityD.class);
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        intent = new Intent(ListActivityD.this, HotelesActivityD.class);
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent = new Intent (ListActivityD.this, RestActivityD.class);
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        intent = new Intent (ListActivityD.this, QhActivityD.class);
                        intent.putExtra("username", username);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }

            }
        });

    }

    class Adapter extends ArrayAdapter<Lista_Entrada> {
        // constructor
        public Adapter(@NonNull Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item,datos);//donde lo queremos poner y que vamos a poner
        }

        @NonNull
        @Override

        //mostrar la informacion contenida en el objeto
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            // item es el objeto lista
            LayoutInflater inflater = LayoutInflater.from(getContext());//nos traemos la vista
            View item = inflater.inflate(R.layout.list_item,null);// la cargamos

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direcc = (TextView) item.findViewById(R.id.tDirecc);
            direcc.setText(datos[position].getDirecc());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;

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
                intent = new Intent (ListActivityD.this, MainActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_list:
                intent = new Intent (ListActivityD.this, ListActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_hotel:
                intent = new Intent (ListActivityD.this, HotelesActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_rest:
                intent = new Intent (ListActivityD.this, RestActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_qh:
                intent = new Intent (ListActivityD.this, QhActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_mi_perfil:
                intent = new Intent (ListActivityD.this, PerfilActivityD.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.nav_sing_out:
                intent = new Intent (ListActivityD.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Sección cerrada", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
