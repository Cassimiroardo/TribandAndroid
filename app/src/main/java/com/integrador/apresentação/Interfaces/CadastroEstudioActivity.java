package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.integrador.apresetação.R;
import com.integrador.model.classes.Estudio;
import com.integrador.model.classes.Localizacao;
import com.integrador.services.EstudioService;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class CadastroEstudioActivity extends AppCompatActivity implements Validator.ValidationListener{

    @NotEmpty(message = "Nome Obrigatório")
    private EditText etNome;

    @Email(message = "Email Obrigatório")
    private EditText etEmail;

    @Password(message = "Senha Obrigatória")
    private EditText etSenha;

    @ConfirmPassword
    private EditText etConfSenha;

    @NotEmpty(message = "Rua Obrigatória")
    private EditText etRua;

    @NotEmpty(message = "Numero da rua Obrigatório")
    private EditText etNumRua;

    @NotEmpty(message = "Telefone Obrigatório")
    private EditText etTelefone;

    @NotEmpty(message = "Cep Obrigatório")
    private EditText etCep;

    @NotEmpty(message = "Estado Obrigatório")
    private EditText etEstado;

    @NotEmpty(message = "Cidade Obrigatória")
    private EditText etCidade;

    @NotEmpty(message = "Bairro Obrigatório")
    private EditText etBairro;

    @NotEmpty(message = "Preco Obrigatório")
    private EditText etPreco;

    @NotEmpty(message = "Cnpj Obrigatório")
    private EditText etCnpj;

    @Checked(message = "Aceite os termos")
    private CheckBox cbTermos;

    private Button btCadastrar;

    private Estudio estudio;
    private EstudioService estudioService;
    private Validator validator;

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


    @Override
    public void onValidationSucceeded() {

        this.estudio.setPreco(Double.parseDouble(etPreco.getText().toString()));
        this.estudio.setCnpj(etCnpj.getText().toString());
        this.estudio.setDescricao("insira a descrição na aba de editar perfil");

        Localizacao l = new Localizacao();
        l.setBairro(etBairro.getText().toString());
        l.setCep(Long.parseLong(etCep.getText().toString()));
        l.setCidade(etCidade.getText().toString());
        l.setNumero(Integer.parseInt(etNumRua.getText().toString()));
        l.setEstado(etEstado.getText().toString().toUpperCase());

        this.estudio.setLocalizacao(l);
//        this.estudio
//        this.estudio
//        this.estudio
//        this.estudio
//        this.estudio





    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }
}
