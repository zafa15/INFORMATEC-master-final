package com.varius.alex.informatec;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class Cate_1_filter extends AppCompatActivity {

    Button btn_filtrar;
    String PRODUCT_URL = "";
    String cadena;
    CategoriaActivity_Adapter adapter;
    List<CategoriaProduct> productList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        btn_filtrar = (Button) findViewById(R.id.btn_filtrar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cate_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();
        Bundle datosr=getIntent().getExtras();
        PRODUCT_URL=datosr.getString("cadena");

        loadProducts();





    }
    private void loadProducts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,PRODUCT_URL ,
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
                            adapter = new CategoriaActivity_Adapter(Cate_1_filter.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Cate_1_filter.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
