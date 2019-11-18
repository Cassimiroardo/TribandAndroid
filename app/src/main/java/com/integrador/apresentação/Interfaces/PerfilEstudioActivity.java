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

import androidx.fragment.app.FragmentTransaction;

import com.integrador.apresetação.R;
import com.integrador.model.classes.Estudio;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilEstudioActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button bt_configuracao;
    private CircleImageView ivUsuario;
    private Button btAgenda;
    private Button btPesquisa;
    private Button btChat;
    private FragmentTransaction transaction;
    private Button btConfiguracao;

    private TextView tvTelefone;
    private TextView tvEmail;
    private TextView tvPreco;
    private TextView tvDescricao;

    private Estudio estudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudio);
        inicializa();
        construindoPerfil();
    }

    private void construindoPerfil(){
        Intent i = getIntent();

        this.estudio = (Estudio) i.getSerializableExtra("estudio");
        String telefone ="("+estudio.getTelefone().substring(0,2)+") "+estudio.getTelefone().substring(2,4)+" "+estudio.getTelefone().substring(4,8)+"-"+estudio.getTelefone().substring(8,estudio.getTelefone().length());
        this.tvTelefone.setText(telefone);
        this.tvPreco.setText("R$ "+estudio.getPreco()+" por hora");
        this.tvDescricao.setText(estudio.getDescricao());
        this.tvEmail.setText(estudio.getEmail());
    }

    private void inicializa(){
        this.tvEmail = findViewById(R.id.tv_email);
        this.tvDescricao = findViewById(R.id.tv_descricao);
        this.tvPreco = findViewById(R.id.tv_preco);
        this.tvTelefone = findViewById(R.id.tv_telefone);

        this.bt_configuracao= findViewById(R.id.bt_configuracao);
        this.btAgenda = findViewById(R.id.bt_agenda);
        this.btPesquisa = findViewById(R.id.bt_pesquisa);
        this.btChat = findViewById(R.id.bt_chat);
        this.ivUsuario = findViewById(R.id.iv_foto_usuario);
    }

    public void showPopUp(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.configuracoes);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.editar:
                Intent intent = new Intent(PerfilEstudioActivity.this,EditarEstudioActivity.class);
                startActivity(intent);
                return true;
            case R.id.sair:
                Toast.makeText(this,"Até Mais!",Toast.LENGTH_LONG).show();
                return true;
            default:
                return false;
        }

    }
}
