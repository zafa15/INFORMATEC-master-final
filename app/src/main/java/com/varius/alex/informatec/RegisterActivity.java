package com.varius.alex.informatec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;
public class RegisterActivity extends AppCompatActivity {
    EditText etNombre, etTelefono, etCorreo, etContraseña;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etNombre=(EditText)findViewById(R.id.et_nombre);
        etTelefono=(EditText)findViewById(R.id.et_telefono);
        etCorreo=(EditText)findViewById(R.id.et_correo);
        etContraseña=(EditText)findViewById(R.id.et_contrasena);
        btnAgregar=(Button)findViewById(R.id.btn_cancelar);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("https://iceutpapp.000webhostapp.com/TestDataApp/insertarUsuario.php");
            }
        });

    }

    private void ejecutarServicio(String URL){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String>parametros=new HashMap<String, String>();
                parametros.put("nombre", etNombre.getText().toString());
                parametros.put("telefono", etTelefono.getText().toString());
                parametros.put("correo", etCorreo.getText().toString());
                parametros.put("contraseña", etContraseña.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
