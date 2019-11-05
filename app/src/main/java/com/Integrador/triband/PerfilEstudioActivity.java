package com.Integrador.triband;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.ActionMenuView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class PerfilEstudioActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button bt_configuracao;
    private ImageView ivUsuario;
    private Button btAgenda;
    private Button btPesquisa;
    private Button btChat;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    private Button btConfiguracao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudio);
        inicializa();
    }

    private void inicializa(){
        this.bt_configuracao= findViewById(R.id.bt_configuracao);
        this.fragmentManager = getSupportFragmentManager();
        this.transaction = fragmentManager.beginTransaction();
        this.transaction.add(R.id.container,new MapsFragment(),"mapsFragment");
        transaction.commitAllowingStateLoss();
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
