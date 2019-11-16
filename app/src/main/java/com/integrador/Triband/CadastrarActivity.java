package com.integrador.Triband;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastrarActivity extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etAno;
    private EditText etGenero;
    private Button btCadastrar;
    private FilmeService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_cadastrar);
        this.inicializaComponentes();
        this.btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filme filme = new Filme();
                filme.setTitulo(etTitulo.getText().toString());
                filme.setAno(Integer.parseInt(etAno.getText().toString()));
                filme.setGenero(etGenero.getText().toString());

                // FALTA ENVIAR PARA O SERVIDOR
                service.adicionar(filme).enqueue(new Callback<Filme>() {
                    @Override
                    public void onResponse(Call<Filme> call, Response<Filme> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(CadastrarActivity.this, "Filme cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(CadastrarActivity.this, "Falha no cadastro, tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Filme> call, Throwable t) {
                        Toast.makeText(CadastrarActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void inicializaComponentes() {
//        this.etTitulo = findViewById(R.id.et_titulo);
//        this.etAno = findViewById(R.id.et_ano);
//        this.etGenero = findViewById(R.id.et_genero);
//        this.btCadastrar = findViewById(R.id.bt_cadastrar);
//        service = RetrofitUtils.retrofit.create(FilmeService.class);
    }
}