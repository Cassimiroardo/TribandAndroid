package com.Integrador.triband;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditarBandaActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenhaAtual;
    private EditText etNovaSenha;
    private EditText etConfSenha;
    private EditText etNumIntegrantes;
    private Button btAlterarFoto;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_banda);
        inicializa();

        this.btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarBandaActivity.this,PerfilBandaActivity.class);
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
        this.etNumIntegrantes = findViewById(R.id.et_qnt_integrantes);
        this.btAlterarFoto = findViewById(R.id.bt_mudar_foto);
        this.btSalvar = findViewById(R.id.bt_salvar);
    }

}
