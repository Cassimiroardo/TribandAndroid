package com.Integrador.triband;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class PerfilActivity extends AppCompatActivity {

    ImageView ivUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        inicializa();
    }

    private void inicializa(){
        this.ivUsuario = findViewById(R.id.iv_foto_usuario);
    }

}
