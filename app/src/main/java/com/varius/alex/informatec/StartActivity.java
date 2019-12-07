package com.varius.alex.informatec;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button btnCategoria, btnEditarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnCategoria = (Button)findViewById(R.id.btn_Categoria) ;

        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnCategoria = new Intent(StartActivity.this,CATEGORIA_LOCAL.class );
                startActivity(btnCategoria);
            }
        });
        btnEditarPerfil = (Button)findViewById(R.id.btn_perfil) ;
        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnCategoria = new Intent(StartActivity.this,Editar_Perfil.class );
                startActivity(btnCategoria);
            }
        });
 }






}
