package com.example.viper2.municipioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import org.w3c.dom.Text;

public class RegistroActivity extends AppCompatActivity {

    EditText eUsernamer, ePasswordr, eRepasswordr, eCorreor;
    Button bRegistrarser, bCancelarr;
    String username, password, repPassword, correo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eUsernamer = (EditText) findViewById(R.id.eUsernamer);
        ePasswordr = (EditText) findViewById(R.id.ePasswordr);
        eRepasswordr = (EditText) findViewById(R.id.eRepasswordr);
        eCorreor = (EditText) findViewById(R.id.eCorreor);
        bRegistrarser = (Button) findViewById(R.id.bRegistrarser);
        bCancelarr = (Button) findViewById(R.id.bCancelarr);

        bRegistrarser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (eUsernamer.getText().toString().equals("") || ePasswordr.getText().toString().equals("")|| eRepasswordr.getText().toString().equals("")|| eCorreor.getText().toString().equals("")){
                    // validar que todos los campos esten llenos
                    Toast.makeText(getApplicationContext(),"Aun hay campos sin llenar", Toast.LENGTH_SHORT).show();
                }else {
                    if(!ePasswordr.getText().toString().equals(eRepasswordr.getText().toString())){
                        //validar que el password y repPassword sean iguales
                        Toast.makeText(getApplicationContext(),"Exite diferencia en las contraseñas", Toast.LENGTH_SHORT).show();
                        ((EditText) findViewById(R.id.ePasswordr)).setText("");
                        ((EditText) findViewById(R.id.eRepasswordr)).setText("");
                    }else{
                        if(eCorreor.getText().toString().indexOf("@")<0){
                            //validar que el email
                            Toast.makeText(getApplicationContext(),"Email Erroneo", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.eCorreor)).setText("");
                        }else {
                            username = eUsernamer.getText().toString();
                            password = ePasswordr.getText().toString();
                            repPassword = eRepasswordr.getText().toString();
                            correo = eCorreor.getText().toString();

                            intent = new Intent();
                            intent.putExtra("username", username);
                            intent.putExtra("password", password);
                            intent.putExtra("correo", correo);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    }
                }
            }
        });

        bCancelarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}