package com.integrador.Triband;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarActivity extends ListActivity {

    private FilmeService service;
    private List<Filme> listaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        service = RetrofitUtils.retrofit.create(FilmeService.class);

        service.listarFilmes().enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {

                if(response.isSuccessful()) {
                    listaFilmes = response.body();
                    ArrayAdapter<Filme> adapter = new ArrayAdapter<>(ListarActivity.this, android.R.layout.simple_list_item_1, listaFilmes);
                    setListAdapter(adapter);
                }else {
                    Toast.makeText(ListarActivity.this, "Não foi possível buscar a lista de filmes. Tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Toast.makeText(ListarActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int acao = getIntent().getIntExtra("ACAO",0);
        if(acao==1) {
            // quem chamou a ListarActivity foi o menu de editar
            // então tem que abrir a tela de editar enviando o objeto selecionado
            Intent itTelaEditar = new Intent(this, EditarActivity.class);
            // pega o filme selecionado e joga pro objeto filme
            Filme filme = listaFilmes.get(position);
            // envia o objeto filme pela intent para a EditarActivity
            itTelaEditar.putExtra("filme", filme);
            startActivity(itTelaEditar);
            finish();
        }else if(acao==2){
            // quem chamou a ListarActivity foi o menu de excluir
            // então tem que chamar o método de deletar do FilmeService
            int idFilme = listaFilmes.get(position).getId();
            service.deletar(idFilme).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful()) {
                        Toast.makeText(ListarActivity.this, "Filme excluído com sucesso!", Toast.LENGTH_LONG).show();
                        finish();
                    }else {
                        Toast.makeText(ListarActivity.this, "Não foi possível excluir o filme selecionado. Tente novamente mais tarde!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(ListarActivity.this, "Falha na comunicação! Verifique sua internet e tente novamente!", Toast.LENGTH_LONG).show();
                }
            });
            finish();
        }
    }
}