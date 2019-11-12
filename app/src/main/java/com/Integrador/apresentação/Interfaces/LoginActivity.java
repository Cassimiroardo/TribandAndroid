package com.Integrador.apresentação.Interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.Integrador.apresentação.R;

public class LoginActivity extends AppCompatActivity {

    ImageView ivLogo;
    EditText etEmail;
    EditText etSenha;
    Button btLogar;
    Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializa();

        this.btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              logar();
            }
        });

    }

    private void inicializa(){
        this.ivLogo = findViewById(R.id.iv_logo);
        this.etEmail = findViewById(R.id.et_email);
        this.etSenha = findViewById(R.id.et_senha);
        this.btLogar = findViewById(R.id.bt_logar);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
    }

    public void logar(){
        Intent intent = new Intent(this,PerfilActivity.class);
        startActivity(intent);
    }

}
