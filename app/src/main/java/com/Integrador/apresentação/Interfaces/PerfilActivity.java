package com.Integrador.apresentação.Interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.Integrador.apresentação.R;

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
