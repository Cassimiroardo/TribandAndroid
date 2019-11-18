package com.integrador.apresentação.Interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.integrador.apresetação.R;
import com.integrador.model.classes.Chat;
import com.integrador.model.classes.Mensagem;
import com.integrador.model.utilitarios.Usuario;
import com.integrador.services.MensagemService;
import com.integrador.services.RetrofitUtils;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {

    private Chat chat;
    private Usuario local;
    private Usuario web;
    private ArrayList<Mensagem> mensagens;
    private MensagemService service = RetrofitUtils.retrofit.create(MensagemService.class);
    private TextView tv_nome_web;
    private Button bt_sair;
    private EditText et_mensagem;
    private Button bt_envia;
    private ArrayAdapter<Mensagem> mensagemAdapter;

    private void inicializaComponentes(){
        chat = (Chat) getIntent().getSerializableExtra("chat");
        if(getIntent().getStringExtra("tipo").equals("estudio")) {
            local = chat.getEstudio();
            web = chat.getBanda();
        }
        else{
            local = chat.getBanda();
            web = chat.getEstudio();
        }

        tv_nome_web = findViewById(R.id.tv_nome_web);
        bt_sair = findViewById(R.id.bt_sair);
        et_mensagem = findViewById(R.id.et_mensagem);
        bt_envia = findViewById(R.id.bt_envia);

        service.buscarPorChat(chat).enqueue(new Callback<List<Mensagem>>() {
            @Override
            public void onResponse(Call<List<Mensagem>> call, Response<List<Mensagem>> response) {
                if(response.isSuccessful())
                    mensagens = (ArrayList) response.body();
                else
                    mensagens = new ArrayList<>();



                mensagemAdapter = new ArrayAdapter<Mensagem>(ChatActivity.this,android.R.layout.simple_list_item_1,mensagens);

            }

            @Override
            public void onFailure(Call<List<Mensagem>> call, Throwable t) {

            }
        });

        tv_nome_web.setText(web.getNome());



        bt_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt_envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = et_mensagem.getText().toString();
                if(mensagem.length()==0) return;

                Mensagem nova = new Mensagem();
                nova.setConteudo(mensagem);
                nova.setHorario(null);
                nova.setChat(chat);
                service.adicionar(nova).enqueue(new Callback<Mensagem>() {
                    @Override
                    public void onResponse(Call<Mensagem> call, Response<Mensagem> response) {
                        if(response.isSuccessful())
                            mensagemAdapter.add(response.body());
                    }

                    @Override
                    public void onFailure(Call<Mensagem> call, Throwable t) {

                    }
                });


            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        inicializaComponentes();

        Thread contador = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    service.buscarPorChat(chat).enqueue(new Callback<List<Mensagem>>() {
                        @Override
                        public void onResponse(Call<List<Mensagem>> call, Response<List<Mensagem>> response) {
                            if (response.isSuccessful()) {
                                ArrayList<Mensagem> novas = (ArrayList) response.body();

                                for (int i = mensagens.size(); i < novas.size(); i++) {
                                    mensagens.add(novas.get(i));
                                }


                            }
                        }

                        @Override
                        public void onFailure(Call<List<Mensagem>> call, Throwable t) {
                        }
                    });
                    try {
                        wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        contador.start();
    }
}
