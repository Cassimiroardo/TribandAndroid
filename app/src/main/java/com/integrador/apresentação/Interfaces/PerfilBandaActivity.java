package com.integrador.apresentação.Interfaces;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.integrador.apresetação.R;
import com.integrador.model.Banda;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilBandaActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private CircleImageView ivUsuario;
    private Button btChat;
    private Button btAgenda;
    private Button btPesquisa;
    private Button btConfiguracao;
    private TextView tvNomeBanda;
    private TextView tvIntegrantes;
    private TextView tvEmail;

    private Banda usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_banda);
        inicializa();
        construindoPerfil();
    }

    public void construindoPerfil(){

        Intent i = getIntent();
        this.usuario = (Banda) i.getSerializableExtra("banda");
        this.tvNomeBanda.setText(usuario.getNome());
        this.tvEmail.setText(usuario.getEmail());
        this.tvIntegrantes.setText(usuario.getIntegrantes()+" Integrantes");
    }

    public void showPopUp(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.configuracoes);
        popupMenu.show();
    }

    private void inicializa() {
        this.tvEmail = findViewById(R.id.tv_email);
        this.tvNomeBanda = findViewById(R.id.tv_nome_usuario_banda);
        this.tvIntegrantes = findViewById(R.id.tv_integrantes);
        this.btConfiguracao = findViewById(R.id.bt_configuracao);
        this.btAgenda = findViewById(R.id.bt_agenda);
        this.btPesquisa = findViewById(R.id.bt_pesquisa);
        this.btChat = findViewById(R.id.bt_chat);
        this.ivUsuario = findViewById(R.id.iv_foto_usuario);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editar:
                Intent intent = new Intent(PerfilBandaActivity.this, EditarBandaActivity.class);
                startActivity(intent);
                return true;
            case R.id.sair:
                Toast.makeText(this, "Até Mais!", Toast.LENGTH_LONG).show();
                return true;
            default:
                return false;
        }
    }

    public void telaDePesquisa(View v){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PesquisarActivity.class);
                startActivity(intent);
            }
        });
    }

}
