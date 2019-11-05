package com.Integrador.triband;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroBandaActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etSenha;
    private EditText etSenhaConf;
    private CheckBox cbTermos;
    private EditText etIntegrantes;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_banda);
        inicializa();

        cadastro();

    }

    private void inicializa(){
        this.etNome = findViewById(R.id.et_nome);
        this.etSenha = findViewById(R.id.et_senha);
        this.etSenhaConf = findViewById(R.id.et_senha_conf);
        this.cbTermos = findViewById(R.id.cb_termos);
        this.etIntegrantes = findViewById(R.id.et_qnt_integrantes);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
    }


    private void cadastro(){

        if(true) {

            this.btCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CadastroBandaActivity.this, PerfilBandaActivity.class);
                    startActivity(intent);
                }
            });
        }else{
            Toast.makeText(CadastroBandaActivity.this,"Erro no cadastro", Toast.LENGTH_SHORT).show();
        }
    }


}
