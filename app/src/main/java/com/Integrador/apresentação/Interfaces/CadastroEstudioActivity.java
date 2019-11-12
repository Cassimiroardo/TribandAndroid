package com.Integrador.apresentação.Interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.Integrador.apresentação.R;

public class CadastroEstudioActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etConfSenha;
    private EditText etRua;
    private EditText etNumRua;
    private EditText etTelefone;
    private EditText etCep;
    private EditText etEstado;
    private EditText etCidade;
    private EditText etBairro;
    private EditText etPreco;
    private EditText etCnpj;
    private CheckBox cbTermos;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_estudio);
        inicializa();

        cadastro();

    }


    private void inicializa(){
        this.etNome = findViewById(R.id.et_nome);
        this.etEmail = findViewById(R.id.et_email);
        this.etSenha = findViewById(R.id.et_senha);
        this.etConfSenha = findViewById(R.id.et_senha_conf);
        this.etRua = findViewById(R.id.et_rua);
        this.etNumRua = findViewById(R.id.et_numero_rua);
        this.etTelefone = findViewById(R.id.et_telefone);
        this.etCep = findViewById(R.id.et_cep);
        this.etEstado = findViewById(R.id.et_estado);
        this.etCidade = findViewById(R.id.et_cidade);
        this.etBairro = findViewById(R.id.et_bairro);
        this.etPreco = findViewById(R.id.et_preco);
        this.etCnpj = findViewById(R.id.et_cnpj);
        this.cbTermos = findViewById(R.id.cb_termos);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
    }

    private void cadastro(){

        if(true) {

            this.btCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CadastroEstudioActivity.this, PerfilEstudioActivity.class);
                    startActivity(intent);
                }
            });
        }else{
            Toast.makeText(CadastroEstudioActivity.this,"Erro no cadastro", Toast.LENGTH_SHORT).show();
        }
    }


}
