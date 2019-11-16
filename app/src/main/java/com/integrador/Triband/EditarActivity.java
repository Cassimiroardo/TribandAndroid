package com.integrador.Triband;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EditarActivity extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etAno;
    private EditText etGenero;
    private Button btEditar;
    private Retrofit retrofit;
    private FilmeService service;
    private Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // reaproveitando o layout do cadastrar
        //setContentView(R.layout.activity_cadastrar);
        this.inicializaComponentes();
        // pega o filme que foi enviado pela intent
        filme = (Filme)getIntent().getExtras().getSerializable("filme");
        // preenche os editText com o filme selecionado
        this.etTitulo.setText(filme.getTitulo());
        this.etAno.setText(filme.getAno().toString());
        this.etGenero.setText(filme.getGenero());
        this.btEditar.setText("Editar");
        this.btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // atualiza o objeto filme com os valores que o usuario alterou nos editTexts
                filme.setTitulo(etTitulo.getText().toString());
                filme.setAno(Integer.parseInt(etAno.getText().toString()));
                filme.setGenero(etGenero.getText().toString());
                // chama o servidor para atualizar o filme
                service.atualizar(filme).enqueue(new Callback<Filme>() {
                    @Override
                    public void onResponse(Call<Filme> call, Response<Filme> response) {
                        if(response.isSuccessful()) {
                            filme = response.body();
                            Toast.makeText(EditarActivity.this, "Filme editado com sucesso!", Toast.LENGTH_LONG).show();
                            finish();
                        }else {
                            Toast.makeText(EditarActivity.this, "Não foi possível editar o filme. Tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Filme> call, Throwable t) {
                        Toast.makeText(EditarActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    private void inicializaComponentes() {
//        this.etTitulo = findViewById(R.id.et_titulo);
//        this.etAno = findViewById(R.id.et_ano);
//        this.etGenero = findViewById(R.id.et_genero);
//        this.btEditar = findViewById(R.id.bt_cadastrar);
//        service = RetrofitUtils.retrofit.create(FilmeService.class);
    }
}
