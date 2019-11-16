package com.integrador.model;

import java.io.Serializable;

class SubServico implements Serializable {

    private String descricao;
    private Long idSubservico;
    private Servico servico;

    public SubServico() {
        super();
    }

    public SubServico(Long idSubServico, String descricao, Servico servico) {
        super();
        this.idSubservico = idSubServico;
        this.descricao = descricao;
        this.servico = servico;

    }

    public Long getId() {
        return idSubservico;
    }

    public void setId(Long id) {
        this.idSubservico = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
