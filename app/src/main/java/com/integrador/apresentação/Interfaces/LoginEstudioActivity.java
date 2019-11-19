package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.integrador.apresetação.R;
import com.integrador.model.classes.Estudio;
import com.integrador.services.EstudioService;
import com.integrador.services.RetrofitUtils;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginEstudioActivity extends AppCompatActivity implements Validator.ValidationListener{

    private Estudio estudio;
    private EstudioService estudioService;
    private Validator validator;

    @Email(message = "Email Obrigatório")
    private EditText etEmail;

    @Password(message = "Senha Obrigatória")
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
            public void onClick(View view) {
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
        this.validator = new Validator(this);
        this.validator.setValidationListener(this);
        this.estudio = new Estudio();
        this.estudioService = RetrofitUtils.retrofit.create(EstudioService.class);

        this.etEmail = findViewById(R.id.et_email);
        this.etSenha = findViewById(R.id.et_senha);
        this.btLogar = findViewById(R.id.bt_logar);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
    }

    private void logar(){
        this.validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        this.btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Call<Estudio> call = estudioService.buscarPorEmailEsenha(etEmail.getText().toString(),etSenha.getText().toString());

                call.enqueue(new Callback<Estudio>() {
                    @Override
                    public void onResponse(Call<Estudio> call, Response<Estudio> response) {

                        if (response.isSuccessful()) {
                            estudio = response.body();

                            Intent intent = new Intent(LoginEstudioActivity.this,PerfilEstudioActivity.class);

                            intent.putExtra("estudio",estudio);

                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginEstudioActivity.this, "Login Invalido!!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Estudio> call, Throwable t) {
                        Toast.makeText(LoginEstudioActivity.this, "Login invalido!!!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }
}
