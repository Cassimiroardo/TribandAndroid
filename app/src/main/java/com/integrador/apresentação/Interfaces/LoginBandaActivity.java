package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.integrador.apresetação.R;
import com.integrador.model.Banda;
import com.integrador.services.BandaService;
import com.integrador.services.RetrofitUtils;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class LoginBandaActivity extends AppCompatActivity implements Validator.ValidationListener {

    @Email(message = "Email Obrigatório")
    private EditText etEmail;

    @Password(message = "Senha Obrigatória")
    private EditText etSenha;

    private Button btLogar;
    private Button btCadastrar;

    private Banda banda;
    private BandaService bandaService;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_banda);
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
                Intent intent = new Intent(LoginBandaActivity.this, CadastroBandaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inicializa() {
        this.validator = new Validator(this);
        this.validator.setValidationListener(this);
        this.bandaService = RetrofitUtils.retrofit.create(BandaService.class);
        this.etEmail = findViewById(R.id.et_email);
        this.etSenha = findViewById(R.id.et_senha);
        this.btLogar = findViewById(R.id.bt_logar);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
    }

    public void logar() {
        this.validator.validate();
    }

    @Override
    public void onValidationSucceeded() {

        Intent intent = new Intent(this, PerfilBandaActivity.class);


        banda = (Banda) bandaService.buscarPorEmailEsenha(etEmail.getText().toString(), etSenha.getText().toString());

        intent.putExtra("banda", this.banda);
        startActivity(intent);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError erro : errors) {
            View v = erro.getView();
            String msg = erro.getCollatedErrorMessage(this);

            if (v instanceof EditText) {
                ((EditText) v).setError(msg);
            }


        }


    }
}
