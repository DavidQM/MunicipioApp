package com.example.viper2.municipioapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {

    TextView eUsername,eCorreo;
    String username="",correo="";
    ImageView fperfil;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        eUsername = (TextView) findViewById(R.id.eUsername);
        eCorreo = (TextView) findViewById(R.id.eCorreo);
        fperfil = (ImageView) findViewById(R.id.fperfil);

        Bundle box =getIntent().getExtras();

        username = String.valueOf(box.getString("username"));
        correo= String.valueOf(box.getString("correo"));

        ((TextView) findViewById(R.id.eUsername)).setText(username);
        ((TextView) findViewById(R.id.eCorreo)).setText(correo);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_perfil_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act_main:
                intent = new Intent(PerfilActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                return true;
            case R.id.sign_out:
                intent = new Intent (PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Sección cerrada", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
