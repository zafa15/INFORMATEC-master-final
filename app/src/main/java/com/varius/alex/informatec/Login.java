package com.varius.alex.informatec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class Login extends AppCompatActivity {
    EditText etCorreo, etContra;
    Button btnIngresar;
    Button btnRegistro;
    JSONArray ja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etCorreo = (EditText) findViewById(R.id.et_correo);
        etContra = (EditText) findViewById(R.id.et_contrasena);
        btnIngresar = (Button) findViewById(R.id.iniciar_sesion);
        btnRegistro = (Button) findViewById(R.id.btn_ir_crearCuenta);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnRegistro = new Intent(Login.this, RegisterActivity.class);
                startActivity(btnRegistro);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConsultaPass("https://iceutpapp.000webhostapp.com/TestDataApp/consultarusuario.php?correo="+etCorreo.getText().toString());
            }
        });

    }

    private void ConsultaPass(String URL) {

        Log.i("url",""+URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =  new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    ja = new JSONArray(response);
                    String contra = ja.getString(0);
                    if(contra.equals(etContra.getText().toString())){
                        try {
                            ja = new JSONArray(response);
                            Intent i = new Intent(Login.this, StartActivity.class);
                            Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_SHORT).show();

                            startActivity(i);
                        } catch ( JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"verifique su contraseña",Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(),"El usuario no existe",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }
}
