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
import com.integrador.model.classes.Localizacao;
import com.integrador.services.EstudioService;
import com.integrador.services.LocalizacaoService;
import com.integrador.services.RetrofitUtils;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarEstudioActivity extends AppCompatActivity implements Validator.ValidationListener{


    private EditText etNome;
    private EditText etEmail;

    @Password(message = "confirme sua senha para realizar a edição")
    private EditText etSenhaAtual;

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



    private LocalizacaoService localizacaoService;
    private EstudioService estudioService;
    private Estudio estudio;
    private Validator validator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_estudio);
        inicializa();


        this.btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });


    }

    private void edit() {
        this.validator.validate();
    }

    private void inicializa(){
        this.validator = new Validator(this);
        this.validator.setValidationListener(this);

        this.estudio = (Estudio) getIntent().getSerializableExtra("estudio");
        this.estudioService = RetrofitUtils.retrofit.create(EstudioService.class);
        this.localizacaoService = RetrofitUtils.retrofit.create(LocalizacaoService.class);

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

    @Override
    public void onValidationSucceeded() {
        if (etSenhaAtual.getText().toString().equals(estudio.getSenha())){


        if(!etNome.getText().toString().equalsIgnoreCase(""))
            this.estudio.setNome(etNome.getText().toString());

        if(!etEmail.getText().toString().equalsIgnoreCase(""))
            this.estudio.setEmail(etEmail.getText().toString());

        if(!etNovaSenha.getText().toString().equalsIgnoreCase("") && !etNovaSenha.getText().toString().equals(estudio.getSenha()) && etNovaSenha.getText().toString().equals(etConfSenha.getText().toString()));
            this.estudio.setSenha(etNovaSenha.getText().toString());

        if(!etRua.getText().toString().equalsIgnoreCase(""))
            this.estudio.getLocalizacao().setRua(etRua.getText().toString());

        if(!etNumRua.getText().toString().equalsIgnoreCase(""))
            this.estudio.getLocalizacao().setNumero(Integer.parseInt(etNumRua.getText().toString()));

        if(!etTelefone.getText().toString().equalsIgnoreCase(""))
            this.estudio.setTelefone(etTelefone.getText().toString());

        if(!etCep.getText().toString().equalsIgnoreCase(""))
            this.estudio.getLocalizacao().setCep(Long.parseLong(etCep.getText().toString()));

        if(!etEstado.getText().toString().equalsIgnoreCase(""))
            this.estudio.getLocalizacao().setEstado(etEstado.getText().toString());

        if(!etCidade.getText().toString().equalsIgnoreCase(""))
            this.estudio.getLocalizacao().setCidade(etCidade.getText().toString());

        if(!etBairro.getText().toString().equalsIgnoreCase(""))
            this.estudio.getLocalizacao().setBairro(etBairro.getText().toString());

        if(!etPreco.getText().toString().equalsIgnoreCase(""))
            this.estudio.setPreco(Double.parseDouble(etPreco.getText().toString()));



        Call<Localizacao> call = localizacaoService.atualizar(estudio.getLocalizacao());

        call.enqueue(new Callback<Localizacao>() {
            @Override
            public void onResponse(Call<Localizacao> call, Response<Localizacao> response) {
                if(response.isSuccessful()){

                    Call<Estudio> caall = estudioService.atualizar(estudio);

                    caall.enqueue(new Callback<Estudio>() {
                        @Override
                        public void onResponse(Call<Estudio> call, Response<Estudio> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(EditarEstudioActivity.this, "Dados editados!!!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(EditarEstudioActivity.this,PerfilEstudioActivity.class);
                                intent.putExtra("estudio",estudio);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<Estudio> call, Throwable t) {

                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<Localizacao> call, Throwable t) {

            }
        });



        }else{
            Toast.makeText(EditarEstudioActivity.this, "Senha Atual incorreta!!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }
}
