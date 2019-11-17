package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.integrador.apresetação.R;
import com.integrador.model.Banda;
import com.integrador.services.BandaService;
import com.integrador.services.RetrofitUtils;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Password;

public class EditarBandaActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEmail;
    private EditText etSenhaAtual;

    @Nullable
    @Password
    private EditText etNovaSenha;

    @ConfirmPassword
    private EditText etConfSenha;
    private EditText etNumIntegrantes;
    private Button btAlterarFoto;
    private Button btSalvar;

    private Banda banda;
    private BandaService bandaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_banda);
        inicializa();
        edit();

    }

    private void edit(){

        this.btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                Intent intent = new Intent(EditarBandaActivity.this,PerfilBandaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inicializa(){
        this.banda = (Banda) getIntent().getSerializableExtra("banda");
        this.bandaService = RetrofitUtils.retrofit.create(BandaService.class);

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
