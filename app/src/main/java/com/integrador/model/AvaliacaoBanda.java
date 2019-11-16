package com.integrador.model;

import java.io.Serializable;
import java.sql.Date;

public class AvaliacaoBanda implements Serializable {

    private Banda banda;
    private Integer compromissoHorario;
    private Integer cuidadoEquipamento;
    private Date dataAvaliacaoBanda;
    private Long idAvaliacaoBanda;




    public AvaliacaoBanda(Banda banda, Integer compromissoHorario, Integer cuidadoEquipamento, Date dataAvaliacaoBanda,
                          Long idAvaliacaoBanda) {
        super();
        this.banda = banda;
        this.compromissoHorario = compromissoHorario;
        this.cuidadoEquipamento = cuidadoEquipamento;
        this.dataAvaliacaoBanda = dataAvaliacaoBanda;
        this.idAvaliacaoBanda = idAvaliacaoBanda;

    }

    public AvaliacaoBanda() {
        super();
    }

    //GETS E SETS;

    public Long getId() {
        return idAvaliacaoBanda;
    }

    public void setId(Long idAvBanda) {
        this.idAvaliacaoBanda = idAvBanda;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public Integer getCompromissoHorario() {
        return compromissoHorario;
    }

    public void setCompromissoHorario(Integer compromissoHorario) {
        this.compromissoHorario = compromissoHorario;
    }

    public Integer getCuidadoEquipamento() {
        return cuidadoEquipamento;
    }

    public void setCuidadoEquipamento(Integer cuidadoEquipamento) {
        this.cuidadoEquipamento = cuidadoEquipamento;
    }

    public Date getDataAvaliacaoBanda() {
        return dataAvaliacaoBanda;
    }

    public void setDataAvaliacaoBanda(Date dataAvaliacaoBanda) {
        this.dataAvaliacaoBanda = dataAvaliacaoBanda;
    }



}