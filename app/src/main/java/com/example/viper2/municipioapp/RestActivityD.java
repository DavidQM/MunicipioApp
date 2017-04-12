package com.example.viper2.municipioapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class RestActivityD extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    //String username="",correo="";
    //Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        Bundle box =getIntent().getExtras();
        username = String.valueOf(box.getString("username"));
        correo= String.valueOf(box.getString("correo"));
        */

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rest_activity_d, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pmain) {
            Toast.makeText(getApplicationContext(),"main", Toast.LENGTH_SHORT).show();
            // Handle the camera action
        } else if (id == R.id.nav_list) {Toast.makeText(getApplicationContext(),"list", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_hotel) {Toast.makeText(getApplicationContext(),"hotel", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_rest) {Toast.makeText(getApplicationContext(),"rest", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_qh) {Toast.makeText(getApplicationContext(),"qh", Toast.LENGTH_SHORT).show();

        }  else if (id == R.id.nav_mi_perfil) {Toast.makeText(getApplicationContext(),"mi perfil", Toast.LENGTH_SHORT).show();

        }else if (id == R.id.nav_about) {Toast.makeText(getApplicationContext(),"About", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.act_main:
                intent = new Intent (RestsActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.mi_perfil:
                intent = new Intent (RestsActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.hotel:
                intent = new Intent (RestsActivity.this, HotelesActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.qh:
                intent = new Intent (RestsActivity.this, QhActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.sign_out:
                intent = new Intent (RestsActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Sección cerrada", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    RestUnoFragment r1 = new RestUnoFragment();
                    return r1;
                case 1:
                    RestDosFragment r2 = new RestDosFragment();
                    return r2;
                case 2:
                    RestTresFragment r3 = new RestTresFragment();
                    return r3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: String box1 = getString(R.string.RestUno);
                    return box1;
                case 1: String box2 = getString(R.string.RestDos);
                    return box2;
                case 2: String box3 = getString(R.string.RestTres);
                    return box3;
                default: return null;
            }
        }
    }
}
