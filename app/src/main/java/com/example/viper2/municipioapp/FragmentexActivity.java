package com.example.viper2.municipioapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FragmentexActivity extends AppCompatActivity {

    //declaramos los objetos
    FragmentManager fm ;
    FragmentTransaction ft;
    LugarUnoFragment l1;
    LugarDosFragment l2;
    //FragmentManager fm = getFragmentManager();
    //FragmentTransaction ft = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentex);

        //configuracion de objetos
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        l1= new LugarUnoFragment();
        ft.add(android.R.id.content,l1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fragmentex_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ft = fm.beginTransaction();
        if (id==R.id.mFrag1){
            l1= new LugarUnoFragment();
            ft.replace(android.R.id.content,l1).commit();
        }else{
            l2= new LugarDosFragment();
            ft.replace(android.R.id.content,l2).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
