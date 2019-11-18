package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.integrador.apresetação.R;
import com.mobsandgeeks.saripaar.annotation.Password;

public class EditarEstudioActivity extends AppCompatActivity {


    private EditText etNome;
    private EditText etEmail;

    @Password
    private EditText etSenhaAtual;

    @Password
    private EditText etNovaSenha;
    private EditText etConfSenha;
    private EditText etRua;
    private EditText etNumRua;
    private EditText etTelefone;
    private EditText etCep;
    private EditText etEstado;
    private EditText etCidade;
    private EditText etBairro;
    private EditText etPreco;
    private Button btAddFotos;
    private Button btAlterarFoto;
    private Button btSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_estudio);
        inicializa();


        this.btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarEstudioActivity.this,PerfilEstudioActivity.class);
                startActivity(intent);
            }
        });


    }

    private void inicializa(){
        this.etNome = findViewById(R.id.et_nome);
        this.etEmail = findViewById(R.id.et_email);
        this.etSenhaAtual = findViewById(R.id.et_senha_atual);
        this.etNovaSenha = findViewById(R.id.et_senha);
        this.etConfSenha = findViewById(R.id.et_senha_conf);
        this.etRua = findViewById(R.id.et_rua);
        this.etNumRua = findViewById(R.id.et_numero_rua);
        this.etTelefone = findViewById(R.id.et_telefone);
        this.etCep = findViewById(R.id.et_cep);
        this.etEstado = findViewById(R.id.et_estado);
        this.etCidade = findViewById(R.id.et_cidade);
        this.etBairro = findViewById(R.id.et_bairro);
        this.etPreco = findViewById(R.id.et_preco);
        this.btAddFotos = findViewById(R.id.bt_add_foto);
        this.btAlterarFoto = findViewById(R.id.bt_alterar_foto);
        this.btSalvar = findViewById(R.id.bt_salvar);
    }
}
