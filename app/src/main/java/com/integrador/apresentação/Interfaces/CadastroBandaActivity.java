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
import com.integrador.model.Banda;
import com.integrador.services.BandaService;
import com.integrador.services.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CadastroBandaActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etSenha;
    private EditText etSenhaConf;
    private CheckBox cbTermos;
    private EditText etIntegrantes;
    private Button btCadastrar;
    private BandaService bandaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_banda);
        inicializa();
        cadastro();
    }

    private void inicializa(){
        this.etNome = findViewById(R.id.et_nome);
        this.etSenha = findViewById(R.id.et_senha);
        this.etSenhaConf = findViewById(R.id.et_senha_conf);
        this.cbTermos = findViewById(R.id.cb_termos);
        this.etIntegrantes = findViewById(R.id.et_qnt_integrantes);
        this.btCadastrar = findViewById(R.id.bt_cadastrar);
        this.bandaService = RetrofitUtils.retrofit.create(BandaService.class);
    }


    private void cadastro(){
        if(true) {
            this.btCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Banda banda = new Banda();
                    banda.setNome(etNome.getText().toString());
                    banda.setSenha(etSenha.getText().toString());
                    banda.setIntegrantes(Integer.parseInt(etIntegrantes.getText().toString()));

                    bandaService.adicionar(banda).enqueue(new Callback<Banda>() {
                        @Override
                        public void onResponse(Call<Banda> call, Response<Banda> response) {

                            if(response.isSuccessful()){

                                Toast.makeText(CadastroBandaActivity.this, "Cadastro Feito com sucesso!", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(CadastroBandaActivity.this, PerfilBandaActivity.class);
                                intent.putExtra("banda",banda);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(CadastroBandaActivity.this, "Falha no cadastro, tente novamente mais tarde", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<Banda> call, Throwable t) {
                            Toast.makeText(CadastroBandaActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                        }
                    });

                }
            });
        }else{
            Toast.makeText(CadastroBandaActivity.this,"Erro no cadastro", Toast.LENGTH_SHORT).show();
        }
    }


}
