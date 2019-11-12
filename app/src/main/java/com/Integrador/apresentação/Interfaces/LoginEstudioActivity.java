package com.Integrador.apresentação.Interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.Integrador.apresentação.R;

public class LoginEstudioActivity extends AppCompatActivity {

    private ImageView ivLogo;
    private EditText etEmail;
    private EditText etSenha;
    private Button btLogar;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_estudio);
        inicializa();

        this.btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              logar();
            }
        });

        this.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginEstudioActivity.this,CadastroEstudioActivity.class);
                startActivity(intent);
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
        Intent intent = new Intent(this, PerfilEstudioActivity.class);
        intent.putExtra("tipo",1);
        startActivity(intent);
    }

}
