package com.integrador.model;

import java.io.Serializable;
import java.sql.Time;

public class Mensagem implements Serializable {
    //para atualizaçções futuras o sistema de mensagens sera melhorado

    private Chat chat;
    private Time horario;
    private Long idMensagem;
    private String conteudo;

    public Mensagem() {
        super();

    }

    public Mensagem(Chat chat, Time horario, Long idMensagem, String conteudo) {

        super();

        this.chat = chat;
        this.horario = horario;
        this.idMensagem = idMensagem;
        this.conteudo = conteudo;

    }



    public Long getId() {
        return this.idMensagem;
    }
    public void setId(Long id) {
        this.idMensagem = id;
    }


    public String getConteudo() {
        return conteudo;
    }


    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

}
