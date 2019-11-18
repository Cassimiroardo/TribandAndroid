package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.integrador.apresetação.R;
import com.integrador.model.classes.Banda;
import com.integrador.services.BandaService;
import com.integrador.services.RetrofitUtils;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarBandaActivity extends AppCompatActivity implements Validator.ValidationListener {

    private EditText etNome;
    private EditText etEmail;

    @Password(message = "confirme sua senha para realizar a edição")
    private EditText etSenhaAtual;

    private EditText etNovaSenha;
    private EditText etConfSenha;
    private EditText etNumIntegrantes;
    private Button btAlterarFoto;
    private Button btSalvar;

    private Banda banda;
    private BandaService bandaService;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_banda);
        inicializa();


        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit();
            }
        });

    }

    private void edit() {
        this.validator.validate();
    }

    private void inicializa() {
        this.validator = new Validator(this);
        this.validator.setValidationListener(this);

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

    @Override
    public void onValidationSucceeded() {
        if (etSenhaAtual.getText().toString().equals(banda.getSenha())) {

            if (!etEmail.getText().toString().equalsIgnoreCase(""))
                banda.setEmail(etEmail.getText().toString());

            if (!etNome.getText().toString().equalsIgnoreCase(""))
                banda.setNome(etNome.getText().toString());

            if(!etNovaSenha.getText().toString().equalsIgnoreCase("") && !etNovaSenha.getText().toString().equals(banda.getSenha()) && etNovaSenha.getText().toString().equals(etConfSenha.getText().toString()))
                banda.setSenha(etNovaSenha.getText().toString());

            if(!etNumIntegrantes.getText().toString().equalsIgnoreCase(""))
                banda.setIntegrantes(Integer.parseInt(etNumIntegrantes.getText().toString()));

            Call<Banda> call = bandaService.atualizar(banda);

            call.enqueue(new Callback<Banda>() {
                @Override
                public void onResponse(Call<Banda> call, Response<Banda> response) {

                    if (response.isSuccessful()) {
                        Intent intent = new Intent(EditarBandaActivity.this, PerfilBandaActivity.class);
                        banda = response.body();
                        intent.putExtra("banda", banda);
                        Toast.makeText(EditarBandaActivity.this, "Dados editados!!!", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<Banda> call, Throwable t) {
                    Toast.makeText(EditarBandaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(EditarBandaActivity.this, "Senha Atual incorreta!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError erro : errors) {
            View componente = erro.getView();
            String msg = erro.getCollatedErrorMessage(this);
            if (componente instanceof EditText) {
                ((TextView) componente).setError(msg);
            }
        }
    }
}
