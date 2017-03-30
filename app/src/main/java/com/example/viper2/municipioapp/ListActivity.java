package com.example.viper2.municipioapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//import android.view.View.OnItenClickListener;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Intent intent;
    //String[] data = new String[]{"Hotel Los Recuerdos","Villas Cabañas el Retorno","Hotel Benjamar"};

    private Lista_Entrada[] datos = new Lista_Entrada[]{
          new Lista_Entrada(R.drawable.zocalos_min,"Zocalos","texto 2", "Texto3"),
            new Lista_Entrada(R.drawable.culebra_min,"Culebra","texto 2", "Texto3"),
            new Lista_Entrada(R.drawable.cannopy_min,"Canopy","texto 2", "Texto3")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView =(ListView) findViewById(R.id.list);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,data);
        Adapter adapter = new Adapter(this,datos);
        listView.setAdapter(adapter);

        //Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                /*
                switch (position) {
                    case 0:
                        intent = new Intent(ListActivity.this, LoginActivity.class);
                        //intent.putExtra("username", username);
                        //intent.putExtra("correo", correo);
                        startActivity(intent);
                        //finish();
                        break;
                    case 1:
                       intent = new Intent(ListActivity.this, QhDosFragment.class);
                        //intent.putExtra("username", username);
                        //intent.putExtra("correo", correo);
                        startActivity(intent);
                        //finish();
                        break;
                    case 2:
                       intent = new Intent (ListActivity.this, QhTresFragment.class);
                        //intent.putExtra("username", username);
                        //intent.putExtra("correo", correo);
                        startActivity(intent);
                        //finish();
                        break;

                    default:
                        break;
                }
                */
                String opcion = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(),opcion,Toast.LENGTH_SHORT).show();

            }
        });
    }
    class Adapter extends ArrayAdapter<Lista_Entrada>{
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
}
