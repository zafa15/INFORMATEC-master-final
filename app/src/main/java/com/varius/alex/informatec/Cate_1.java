package com.varius.alex.informatec;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Cate_1 extends AppCompatActivity {
    private static final String PRODUCT_URL = "https://iceutpapp.000webhostapp.com/TestDataApp/1.php";
    CategoriaActivity_Adapter adapter;
    List<CategoriaProduct> productList;
    RecyclerView recyclerView;
    Button btnCategoria;
    EditText txt_minimo, txt_maximo;
    String PRODUCT_URL2 ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cate_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();
        txt_minimo = (EditText) findViewById(R.id.campo_texto1);
        txt_maximo = (EditText) findViewById(R.id.campo_texto2);
        loadProducts();
        btnCategoria = (Button)findViewById(R.id.btn_filtrar) ;
        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnCategoria = new Intent(Cate_1.this,Cate_1_filter.class );
                Bundle dato=new Bundle();
                dato.putString("cadena","https://iceutpapp.000webhostapp.com/TestDataApp/selecionCamarasPrecio.php?v1="+txt_minimo.getText().toString()+"&v2="+txt_maximo.getText().toString()+"");
                btnCategoria.putExtras(dato);
                startActivity(btnCategoria);
            }
        });

    }

    private void loadProducts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject producObjet = array.getJSONObject(i);
                                int id = producObjet.getInt("id");
                                String name = producObjet.getString("name");
                                String description = producObjet.getString("description");
                                int  price = producObjet.getInt("price");
                                int stock = producObjet.getInt("stock");
                                String img_url = producObjet.getString("img_url");
                                CategoriaProduct product = new CategoriaProduct(id, name, description, price, stock, img_url);
                                productList.add(product);
                            }
                            adapter = new CategoriaActivity_Adapter(Cate_1.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Cate_1.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}