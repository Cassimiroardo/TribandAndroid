package com.integrador.Triband;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PrincipalActivity extends ListActivity {

    private String[] vetMenu = {"Cadastrar","Editar","Excluir","Listar"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, vetMenu);
        setListAdapter(adapter);


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent itTelaListar;
        switch(position) {
            case 0:
                Intent itTelaCadastrar = new Intent(this, CadastrarActivity.class);
                startActivity(itTelaCadastrar);
                break;
            case 1:
                itTelaListar = new Intent(this, ListarActivity.class);
                itTelaListar.putExtra("ACAO", 1);
                startActivity(itTelaListar);
                break;
            case 2:
                itTelaListar = new Intent(this, ListarActivity.class);
                itTelaListar.putExtra("ACAO", 2);
                startActivity(itTelaListar);
                break;
            case 3:
                itTelaListar = new Intent(this, ListarActivity.class);
                startActivity(itTelaListar);
                break;
        }






    }
}
