package com.varius.alex.informatec;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CATEGORIA_LOCAL extends AppCompatActivity {
    Button btnCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnCategoria = (Button)findViewById(R.id.btn_camaras) ;

        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnCategoria = new Intent(CATEGORIA_LOCAL.this,Cate_1.class );
                startActivity(btnCategoria);
            }
        });


    }
}
