package com.integrador.apresentação.Interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.integrador.apresetação.R;
import com.integrador.model.classes.Chat;
import com.integrador.model.classes.Mensagem;
import com.integrador.model.utilitarios.Usuario;
import com.integrador.services.MensagemService;
import com.integrador.services.RetrofitUtils;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Thread contador = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    service.buscarPorChat(chat).enqueue(new Callback<List<MensagemService>>() {
                        @Override
                        public void onResponse(Call<List<MensagemService>> call, Response<List<MensagemService>> response) {
                            if (response.isSuccessful()) {
                                ArrayList<Mensagem> novas = (ArrayList) response.body();

                                for (int i = mensagens.size(); i < novas.size(); i++) {
                                    mensagens.add(novas.get(i));
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<List<MensagemService>> call, Throwable t) {
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
