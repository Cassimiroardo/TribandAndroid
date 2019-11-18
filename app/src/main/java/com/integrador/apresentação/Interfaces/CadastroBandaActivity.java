package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;

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
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CadastroBandaActivity extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty(message = "Nome Obrigatório")
    private EditText etNome;

    @Password(message = "Senha Obrigatória")
    private EditText etSenha;

    @Email(message = "Email Obrigatório")
    private EditText etEmail;

    @ConfirmPassword
    private EditText etSenhaConf;

    @Checked(message = "Aceite os termos")
    private CheckBox cbTermos;

    @NotEmpty(message = "Integrantes Obrigatório")
    private EditText etIntegrantes;

    private Button btCadastrar;
    private BandaService bandaService;
    private Validator validator;
    private Banda banda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_banda);
        inicializa();
        cadastro();
    }

    private void inicializa() {
        this.banda = new Banda();
        this.validator = new Validator(this);
        this.validator.setValidationListener(this);
        this.etEmail = findViewById(R.id.et_email);
        this.etNome = findViewById(R.id.et_nome);
        this.etSenha = findViewById(R.id.et_senha);
        this.etSenhaConf = findViewById(R.id.et_senha_conf);
        this.cbTermos = findViewById(R.id.cb_termos);
        this.etIntegrantes = findViewById(R.id.et_qnt_integrantes);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
        this.bandaService = RetrofitUtils.retrofit.create(BandaService.class);
    }


    private void cadastro() {
        this.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });
    }


    @Override
    public void onValidationSucceeded() {

        this.banda.setNome(etNome.getText().toString());
        this.banda.setEmail(etEmail.getText().toString());
        this.banda.setSenha(etSenha.getText().toString());
        this.banda.setIntegrantes(Integer.parseInt(etIntegrantes.getText().toString()));

        this.bandaService.adicionar(banda).enqueue(new Callback<Banda>() {
            @Override
            public void onResponse(Call<Banda> call, Response<Banda> response) {

                if (response.isSuccessful()) {

                    Toast.makeText(CadastroBandaActivity.this, "Cadastro Feito com sucesso!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CadastroBandaActivity.this, PerfilBandaActivity.class);
                    intent.putExtra("banda", banda);
                    startActivity(intent);
                } else {
                    Toast.makeText(CadastroBandaActivity.this, "Falha no cadastro, tente novamente mais tarde", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Banda> call, Throwable t) {
                Toast.makeText(CadastroBandaActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError erro : errors) {
            View componente = erro.getView();
            String msg = erro.getCollatedErrorMessage(this);
            if (componente instanceof EditText || componente instanceof CheckBox) {
                ((TextView) componente).setError(msg);
            }
        }
    }
}
