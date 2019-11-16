package com.integrador.apresentação.Interfaces;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.integrador.apresetação.R;


public class BemVindoActivity extends AppCompatActivity {

    private TextView bemvindo;
    private Button btBanda;
    private Button btEstudio;
    private Animation cimaprabaixo;
    private Animation baixopracima;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        this.btBanda = findViewById(R.id.bt_banda);
        this.btEstudio = findViewById(R.id.bt_estudio);
        this.bemvindo = findViewById(R.id.bemvindo);
        this.ivLogo = findViewById(R.id.iv_logo);

        btEstudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BemVindoActivity.this,LoginEstudioActivity.class);
                intent.putExtra("tipo",1);
                startActivity(intent);
            }
        });

        btBanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BemVindoActivity.this,LoginBandaActivity.class);
                intent.putExtra("tipo",2);
                startActivity(intent);
            }
        });

        this.cimaprabaixo = AnimationUtils.loadAnimation(this,R.anim.cimaprabaixo);
        this.baixopracima = AnimationUtils.loadAnimation(this,R.anim.baixopracima);
        this.bemvindo.setAnimation(cimaprabaixo);
        this.btBanda.setAnimation(baixopracima);
        this.btEstudio.setAnimation(baixopracima);
    }
}
